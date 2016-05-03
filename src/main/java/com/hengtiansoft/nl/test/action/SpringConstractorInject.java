package com.hengtiansoft.nl.test.action;

import com.hengtiansoft.nl.test.dao.SpringDao;
import com.hengtiansoft.nl.test.dao.User;

public class SpringConstractorInject {
	private SpringDao springDao;
	private User user;

	public SpringConstractorInject(SpringDao springDao, User user) {
		this.springDao = springDao;
		this.user = user;
		System.out.println("构造方法调用springDao和user");
	}
	
	public void save(){
		user.setName("Jack");
		springDao.save(user);
	}

}
