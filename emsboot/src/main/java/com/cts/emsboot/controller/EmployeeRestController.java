package com.cts.emsboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.emsboot.entity.Employee;
import com.cts.emsboot.mapper.EmpDeptMapper;

import com.cts.emsboot.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.PUT, RequestMethod.DELETE })

public class EmployeeRestController {
	@Autowired
	EmployeeService employeeService;
	private static final String EMP_SERVICE_CB = "empServiceCB";

	@GetMapping("/")
	public String helloAppln() {
		return "Hi ADM batch";
	}

	@PostMapping("/addemployee")
	public Employee saveEmp(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/allemployees")
	public List<Employee> fetchAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/empById/{eid}")
	public Optional<Employee> fetchAllEmployees(@PathVariable("eid") Long eid) {

		return employeeService.fetchEmployeeById(eid);

	}

	@GetMapping("/empByName/{ename}")
	public List<Employee> fetchEmployeeByName(@PathVariable("ename") String ename) {
		return employeeService.findEmployeeByEmployeeName(ename);
	}

	@GetMapping("/empByEmail/{email}")
	public Employee fetchEmployeeByEmail(@PathVariable("email") String email) {
		return employeeService.findEmployeeByEmail(email);
	}

	@DeleteMapping("/deleteEmpId/{eid}")
	public void deleteEmployeeById(@PathVariable("eid") Long eid) {
		employeeService.deleteEmployee(eid);
		System.out.println("Employee " + eid + "deleted Successfully");
	}

	@PutMapping("/updateEmpById")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee.getEmployeeId(), employee);

	}


	//@CircuitBreaker(name = EMP_SERVICE_CB, fallbackMethod = "empServiceFallback")
	@GetMapping(value = "/empNdeptById/{eid}")
	public EmpDeptMapper fetchEmployeeWithDept(@PathVariable("eid") Long eid) {

		return employeeService.fetchEmployeeWithDept(eid);
	}

	public EmpDeptMapper empServiceFallback(@PathVariable("eid") Long eid, Exception e)  {
	  return employeeService.noRecordFind(eid);
	
	}

	
	@GetMapping("/otherservicedetails")
	public List otherService() {
		return employeeService.otherService();
	}
}
