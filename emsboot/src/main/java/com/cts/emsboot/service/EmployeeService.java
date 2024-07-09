package com.cts.emsboot.service;

import java.util.List;
import java.util.Optional;

import com.cts.emsboot.entity.Employee;
import com.cts.emsboot.mapper.EmpDeptMapper;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Optional<Employee> fetchEmployeeById(Long employeeId);
	public Employee updateEmployee(Long employeeId,Employee employee);
	public void deleteEmployee(Long employeeId);
	public List<Employee> findEmployeeByEmployeeName(String employeeName);
	public Employee findEmployeeByEmail(String email);
	public EmpDeptMapper fetchEmployeeWithDept(Long eid);
	public EmpDeptMapper noRecordFind(Long eid);
	public List otherService();
//	public String empServiceFallback(Exception e);

}
