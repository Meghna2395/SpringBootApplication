package com.bridgelabz.springbootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.springbootexample.model.Employee;
import com.bridgelabz.springbootexample.model.LoginDTO;

public interface EmployeeRepository extends JpaRepository <Employee, Long>
{

	Employee save(Employee employee);

	Employee getByEmail(String email);
	
	

	
}
