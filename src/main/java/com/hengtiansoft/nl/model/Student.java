package com.hengtiansoft.nl.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class Student implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;

	private String num;
	
	private String clazz;
	
	private String age;
	
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@NotBlank(message="用户名不能为空！")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@NotBlank(message="密码不能为空！")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
