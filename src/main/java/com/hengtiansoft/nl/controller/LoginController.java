package com.hengtiansoft.nl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.service.LoginService;

@Controller
@RequestMapping(value = "/web")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Student student) {
		List<Student> list = loginService.login(student);

		System.out.println(list);
		return "index";
	}

}
