package com.bridgelabz.springbootexample.service;

import java.util.List;

import com.bridgelabz.springbootexample.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployee();

	void deleteEmployee(Long id);

	Employee updateEmployee(Employee employee, long id);


	


	
	
	

}
