package com.cts.emsboot.mapper;

import com.cts.emsboot.entity.Department;
import com.cts.emsboot.entity.Employee;

public class EmpDeptMapper {
	
	private Employee employee;
	private Department department;
	public EmpDeptMapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpDeptMapper(Employee employee, Department department) {
		super();
		this.employee = employee;
		this.department = department;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EmpDeptMapper [employee=" + employee + ", department=" + department + "]";
	}
}
