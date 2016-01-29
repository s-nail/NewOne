package com.hengtiansoft.nl.dao.mybatis;

import java.util.List;

import com.hengtiansoft.nl.model.Student;

public interface LoginMapper {
	public List<Student> getStudent(Student student);
}
