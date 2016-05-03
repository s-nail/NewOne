package com.hengtiansoft.nl.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengtiansoft.nl.dao.mybatis.LoginMapper;
import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	
	public Student login(Student student) {
		
		Student studentResult = loginMapper.getStudent(student);
		
		return studentResult;
	}

}
