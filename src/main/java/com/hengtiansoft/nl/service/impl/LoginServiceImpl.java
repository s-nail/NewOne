package com.hengtiansoft.nl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengtiansoft.nl.dao.mybatis.LoginMapper;
import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.model.param.StudentParam;
import com.hengtiansoft.nl.model.result.StudentResult;
import com.hengtiansoft.nl.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	public Student login(Student student) {

		Student studentResult = loginMapper.getStudent(student);

		return studentResult;
	}

	@Override
	public PageInfo<StudentResult> getStudentList(StudentParam studentParam) {

		PageHelper.startPage(studentParam.getPageNum(),
				studentParam.getPageSize());
		List<StudentResult> studentList = loginMapper
				.getStudentList(studentParam);
		PageInfo<StudentResult> pages=new PageInfo<StudentResult>(studentList);

		return pages;
	}

}
