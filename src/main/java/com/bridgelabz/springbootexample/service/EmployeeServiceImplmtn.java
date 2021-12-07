package com.bridgelabz.springbootexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.springbootexample.model.Employee;
import com.bridgelabz.springbootexample.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplmtn implements EmployeeService {

	private EmployeeRepository empService;

	public EmployeeServiceImplmtn(EmployeeRepository empService) {
		super();
		this.empService = empService;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return empService.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empService.findAll();

	}

	@Override
	public void deleteEmployee(Long id) {
		empService.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = empService.findById(id).get();
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		empService.save(existingEmployee);
		return existingEmployee;
	}

	

}
