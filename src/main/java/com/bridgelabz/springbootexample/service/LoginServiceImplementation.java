package com.bridgelabz.springbootexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springbootexample.model.Employee;
import com.bridgelabz.springbootexample.model.LoginDTO;
import com.bridgelabz.springbootexample.repository.EmployeeRepository;

@Service
public class LoginServiceImplementation implements LoginService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public String login(LoginDTO loginDTO) {

		if (validate(loginDTO)) {
			return "false";
		}

		Employee employee = repository.getByEmail(loginDTO.getEmail());
		if (employee == null) {
			return "false";
		}

		if (employee.getPassword().equals(loginDTO.getPassword())) {
			return "true";
		}
		return "false";

	}

	private boolean validate(LoginDTO loginDTO) {
		return loginDTO.getEmail().isEmpty();
	}

	@Override
	public String forgotPassword(String email, LoginDTO loginDTO) {
		Employee existLoginpass = repository.getByEmail(email);
		existLoginpass.setPassword(loginDTO.getPassword());
		repository.save(existLoginpass);
		return email;

	}

}
