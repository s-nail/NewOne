package com.hengtiansoft.nl.service;

import com.github.pagehelper.PageInfo;
import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.model.param.StudentParam;
import com.hengtiansoft.nl.model.result.StudentResult;

public interface LoginService {
	Student login(Student student);

	PageInfo<StudentResult> getStudentList(StudentParam studentParam);
}
