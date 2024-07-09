package com.cts.emsboot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.emsboot.entity.Employee;
import com.cts.emsboot.service.EmployeeService;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	Employee employee;
	
	@GetMapping("/")
	public String welcome() {
		return "index";

	}

	@RequestMapping(value = "/registerpage", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView signin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/addemp", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("txtename") String ename, @RequestParam("txtemail") String email,
			@RequestParam("txtpass") String pass, @RequestParam("txtgender") String gender,
			@RequestParam("dob") @DateTimeFormat(iso = ISO.DATE) LocalDate doj) {
		System.out.println(ename + " " + email + " " + " " + pass + " " + gender + " " + doj);

		employee = new Employee();
		employee.setEmployeeName(ename);
		employee.setEmail(email);
		employee.setPassword(pass);
		employee.setGender(gender);
		employee.setDoj(doj);
		employeeService.saveEmployee(employee);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam("txtemail") String email, @RequestParam("txtpass") String pass) {
		Employee empl = employeeService.findEmployeeByEmail(email);

		if (empl == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("NOTIFICATION", "Employee DOESN'T Exist");
			return mv;

		} else {
			return allEmployees();
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(Employee empl) {
		employeeService.deleteEmployee(empl.getEmployeeId());
		return allEmployees();
	}

	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(Employee empl) {
		
		return new ModelAndView("edit");
	}

	
	@RequestMapping(value = "/updateemp", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Employee empl) {
		System.out.println(empl);
		Employee emp =employeeService.updateEmployee(empl.getEmployeeId(), empl);
		return allEmployees();
	}
	
	public ModelAndView allEmployees() {
		List<Employee> empList = employeeService.getAllEmployees();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("allemp", empList);
		return mv;
	}


}
