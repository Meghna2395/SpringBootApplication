package com.bridgelabz.springbootexample.service;

import com.bridgelabz.springbootexample.model.LoginDTO;

public interface LoginService {

	String login(LoginDTO loginDTO);

	String forgotPassword(String email, LoginDTO loginDTO);


}
