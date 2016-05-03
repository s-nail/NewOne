package com.hengtiansoft.nl.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengtiansoft.nl.common.model.Head;
import com.hengtiansoft.nl.common.model.MobileReturn;
import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.service.LoginService;
import com.hengtiansoft.nl.util.WebUserUtil;

@Controller
@RequestMapping(value = "/web")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	/*
	 * @responsebody表示该方法的返回结果直接写入HTTP response body中
	 * 一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径，
	 * 加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
	 * 比如异步获取json数据，加上@responsebody后，会直接返回json数据。
	 */
	public MobileReturn<Head> login(HttpServletRequest request,@RequestBody @Validated Student student,BindingResult result) {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("name:"+username+"  password:"+password);
		
		System.out.println("name:"+student.getName()+"  password:"+student.getPassword());
		if (result.hasErrors()) {
			List<ObjectError> listErrors =result.getAllErrors();
			System.out.println("Errors Count:"+listErrors.size());
			for (Iterator<ObjectError> iterator = listErrors.iterator(); iterator.hasNext();) {
				ObjectError objectError = (ObjectError) iterator.next();
				
				System.out.println("Errors : "+objectError);
			}
		}
		Head head = new Head();
		Student stu = WebUserUtil.getWebUser(request);
		if (stu.getName() != null) {
			System.out.println("Session已存在");
			
			head.setMsg("Session已存在");
		}else {
			System.out.println("第一次登陆，Session中不存在");
			
			Student studentResult = loginService.login(student);

			WebUserUtil.setWebUser(request, studentResult);
			
			
			if (studentResult!=null) {
				head.setData(studentResult);
				head.setMsg("学生存在,第一次登陆，Session中不存在");
			}else {			
				head.setMsg("学生不存在");
			}
		}		
		return new MobileReturn<Head>(head);
	}

	/*
	 * 测试HttpSession
	 */
	@RequestMapping(value = "loginSession", method = RequestMethod.POST)
	@ResponseBody
	public MobileReturn<Head> loginSession(@RequestBody Student student,
			HttpServletRequest req) {
		Head head = new Head();

		Student stu = WebUserUtil.getWebUser(req);
		if (stu.getName() != null) {
			head.setMsg("Session已存在");
			System.out.println("Session已存在");
			return new MobileReturn<Head>(head);
		}
		WebUserUtil.setWebUser(req, student);
		head.setMsg("第一次登陆，Session中不存在");
		System.out.println("第一次登陆，Session中不存在");
		return new MobileReturn<Head>(head);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public MobileReturn<Head> logOut(HttpServletRequest request) {
		Head head = new Head();
		//request.getSession().setAttribute(WebUserUtil.USER, null);
		if (WebUserUtil.delWebUser(request)) {
			head.setMsg("logout退出");
		}else {
			head.setMsg("session不存在,logout退出失败，请先登录");
		}
		
		return new MobileReturn<Head>(head);
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Object test() {
		System.out.println("web/test/.....");
		return "test";
	}

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public Object error() {
		System.out.println("error/404/.....");
		return "error/404";
	}
	@RequestMapping(value = "errorPermission", method = RequestMethod.GET)
	public Object errorPermission() {
		System.out.println("error/errorPermission/.....");
		return "error/404";
	}

}
