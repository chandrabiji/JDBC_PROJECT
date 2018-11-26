package com.ems.dao;

import java.util.List;

import com.ems.bean.Employee;

public interface EmployeeDAO {
	
	public void addEmployee();
	public Employee viewEmployee(int empno);
	public List<Employee> viewAllEmployees();
	public void updateEmployee(int empno);
	public void deleteEmployee(int empno);
	

}
