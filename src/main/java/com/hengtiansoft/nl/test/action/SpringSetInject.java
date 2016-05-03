package com.hengtiansoft.nl.test.action;

import com.hengtiansoft.nl.test.dao.SpringDao;
/*
 * Set 注入
 */
public class SpringSetInject {
	//注入对象springDao
	private SpringDao springDao;
   

	public SpringDao getSpringDao() {
		return springDao;
	}

	//一定要写被注入对象的set方法
	public void setSpringDao(SpringDao springDao) {
		this.springDao = springDao;
	}


	public void ok(){
		springDao.ok();
	}
	
}
