package com.bridgelabz.springbootexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.EmployeePayRoll.exception.ResourceNotFoundException;
import com.bridgelabz.EmployeePayRoll.model.Employee;
import com.bridgelabz.springbootexample.model.LoginDTO;
import com.bridgelabz.springbootexample.service.LoginService;
import com.bridgelabz.springbootexample.service.LoginServiceImplementation;

@RestController
@RequestMapping(value = "/employees/api")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		String id = loginService.login(loginDTO);
		if (id.equals("true")) {
			return new ResponseEntity<String>("Logged in Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Your Password is wrong", HttpStatus.NOT_ACCEPTABLE);
		}

	}
	

	@PatchMapping("/forgotPassword/{email}")
	public String forgotPassword(@PathVariable("email") String email, @RequestBody LoginDTO loginDTO) {
		if (loginService.forgotPassword(email, loginDTO) != null){
			return "Password changed";
		}
		
			return "Error Ocuured";
	}

}
