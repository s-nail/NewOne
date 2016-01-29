package com.hengtiansoft.nl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengtiansoft.nl.dao.mybatis.LoginMapper;
import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public List<Student> login(Student student) {
		boolean flag = false;
		List<Student> list = loginMapper.getStudent(student);
		if (list.size() != 0) {
			flag = true;
		}
		return list;
	}

}
