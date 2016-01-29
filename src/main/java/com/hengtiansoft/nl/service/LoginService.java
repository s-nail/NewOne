package com.hengtiansoft.nl.service;

import java.util.List;

import com.hengtiansoft.nl.model.Student;

public interface LoginService {
	List<Student> login(Student student);
}
