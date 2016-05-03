package com.hengtiansoft.nl.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hengtiansoft.nl.model.Student;

public class StudentValidator implements Validator{

	
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", null,"Student name is empty.");
		Student student=(Student) target;
		if (null==student.getPassword()||"".equals(student.getPassword())) {
			errors.rejectValue("password", null, "Password is empty.");
		}

		
	}

}
