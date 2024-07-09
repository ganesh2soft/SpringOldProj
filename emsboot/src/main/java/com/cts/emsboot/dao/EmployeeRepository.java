package com.cts.emsboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.emsboot.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public List<Employee> findEmployeeByEmployeeName(String employeeName);
	public Employee findEmployeeByEmail(String email);
}
