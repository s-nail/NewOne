package com.hengtiansoft.nl.dao.mybatis;


import java.util.List;

import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.model.param.StudentParam;
import com.hengtiansoft.nl.model.result.StudentResult;

public interface LoginMapper {
	public Student getStudent(Student student);
	
	List<StudentResult> getStudentList(StudentParam studentParam);
}
