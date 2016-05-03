package com.hengtiansoft.nl.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hengtiansoft.nl.model.Student;

public class WebUserUtil {
	public static final String USER="WEBUSER";
	/**
	 * 获取session中的用户信息
     * @param request
     * @return
	 * */
	public static Student getWebUser(HttpServletRequest req){
		Object object=req.getSession().getAttribute(USER);
		if(object==null)
		{
			return new Student();
		}
		return (Student) object;
		
	}
	/**
	 * @param request
	 * @param user
	 * 用于保存web端的用户信息到session中
	 * */
	public static void setWebUser(HttpServletRequest req,Student student){
		//req.getSession().setAttribute(USER, student);
		HttpSession session=req.getSession();
		session.setAttribute(USER, student);
	}
	/*
	 * 退出登陆后，清除session中的用户信息
	 * @param request
	 */
	public static boolean delWebUser(HttpServletRequest req){
		
		HttpSession session=req.getSession();
		if(session.getAttribute(USER)!=null){
			session.removeAttribute(USER);
			return true;
		}
		return false;
	}
}
