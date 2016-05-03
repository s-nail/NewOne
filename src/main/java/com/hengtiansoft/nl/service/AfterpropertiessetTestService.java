package com.hengtiansoft.nl.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.hengtiansoft.nl.test.GetBeanByIdOrName;

@Service
public class AfterpropertiessetTestService implements InitializingBean{

	
	public void afterPropertiesSet() throws Exception {
		getBeanByIdOrName();		
	}

	private void getBeanByIdOrName(){
		System.out.println("========================AfterpropertiessetTest   Service=============================");
		//通过id和name获取bean
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("spring-mvc.xml"));
		GetBeanByIdOrName idBean=(GetBeanByIdOrName) factory.getBean("getBeanById");
		GetBeanByIdOrName nameBean=(GetBeanByIdOrName) factory.getBean("getBeanByAlias");
		//如果id和name都没有指定，则用类全名作为name，如,则你可以通过getBean("com.stamen.BeanLifeCycleImpl")返回该实例
		//GetBeanByIdOrName clazzBean=(GetBeanByIdOrName) factory.getBean("com.hengtiansoft.nl.test.GetBeanByIdOrName");
		//System.out.println("clazzBean"+clazzBean);
		System.out.println("idBean:"+idBean);
		System.out.println("nameBean:"+nameBean);
		System.out.println(nameBean==idBean);
		//System.out.println(nameBean==clazzBean);
		
		String[] alias=factory.getAliases("nameBean");
		System.out.println(alias.length);
		for(String name:alias){
			System.out.println("别名:"+name);
		}
		System.out.println("========================XML文件配置在spring-mvc.xml中====================================");
		
	}
}
