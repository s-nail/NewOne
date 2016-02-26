package com.hengtiansoft.nl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengtiansoft.nl.common.model.Head;
import com.hengtiansoft.nl.common.model.MobileReturn;
import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.service.LoginService;

@Controller
@RequestMapping(value = "/web")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	/*	@responsebody表示该方法的返回结果直接写入HTTP response body中
	一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径，
	加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
	比如异步获取json数据，加上@responsebody后，会直接返回json数据。*/
	public MobileReturn<Head> login(@RequestBody Student student) {
		List<Student> list = loginService.login(student);

		System.out.println(list);
		Head head =new Head();
		head.setData(list);
		head.setMsg("学生存在");
		return new MobileReturn<>(head);
	}

}
