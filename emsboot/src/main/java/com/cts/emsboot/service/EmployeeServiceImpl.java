package com.cts.emsboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cts.emsboot.dao.EmployeeRepository;
import com.cts.emsboot.entity.Department;
import com.cts.emsboot.entity.Employee;
import com.cts.emsboot.mapper.EmpDeptMapper;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	
	@Autowired
    private RestTemplate restTemplate;
	
	

	public EmployeeServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		System.out.println("To save : " + employee);
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> fetchEmployeeById(Long employeeId) {

		return employeeRepository.findById(employeeId);
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employee) {
		Employee emp = employeeRepository.findById(employeeId).get();

		emp.setEmployeeName(employee.getEmployeeName());
		emp.setDoj(employee.getDoj());

		return employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public List<Employee> findEmployeeByEmployeeName(String employeeName) {
		return employeeRepository.findEmployeeByEmployeeName(employeeName);
	}

	@Override
	public Employee findEmployeeByEmail(String email) {

		return employeeRepository.findEmployeeByEmail(email);
	}

	

	public EmpDeptMapper fetchEmployeeWithDept(Long eid) {

		EmpDeptMapper edm = new EmpDeptMapper();
	//	RestTemplate restTemplate = new RestTemplate();
		Employee emp = employeeRepository.findById(eid).get();
		
		System.out.println(emp.toString());

		Department dept = restTemplate.getForObject(
				"http://DEPARTMENTSERVICE/department/deptById/" + emp.getDepartmentId(), Department.class);
		System.out.println(dept.toString());
		edm.setEmployee(emp);
		edm.setDepartment(dept);

		return edm;
	}
	
	public EmpDeptMapper  noRecordFind(Long eid) {
		EmpDeptMapper edm1 = new EmpDeptMapper();
		System.out.println("FAll back is active now. Original is downn downn");
		return edm1;
	}
	

	public List otherService() {
		List<Application> applications = eurekaClient.getApplications().getRegisteredApplications();

		for (Application application : applications) {
			List<InstanceInfo> applicationsInstances = application.getInstances();
			for (InstanceInfo applicationsInstance : applicationsInstances) {

				String name = applicationsInstance.getAppName();
				String url = applicationsInstance.getHomePageUrl();
				System.out.println(name + ": " + url);
			}
		}
		return applications;

	}
	
	

}
