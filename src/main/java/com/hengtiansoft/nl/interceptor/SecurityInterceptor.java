package com.hengtiansoft.nl.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hengtiansoft.nl.model.Student;
import com.hengtiansoft.nl.util.ResourceUtil;
import com.hengtiansoft.nl.util.WebUserUtil;

public class SecurityInterceptor implements HandlerInterceptor {
	private List<String> excludePaths;

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("===============登录拦截器  preHandle================");

		String requestPath = ResourceUtil.getRequestPath(request);
		String lastPath = requestPath
				.substring(requestPath.lastIndexOf("/") + 1);
		System.out.println("拦截路径===="+lastPath);
		if (isExcludePath(lastPath)) {
			System.out.println("免过滤Path---->" + lastPath);
			//return true;
		} else {
			//如果路径是需要过滤的，则先判断session中是否存在；如果session中已存在用户信息，则放行：return true，否则跳转error页面
			Student student = WebUserUtil.getWebUser(request);
			if (student.getName() != null) {
				System.out.println("拦截器,session不为空，用户已登录！   StudentName:"+student.getName());
				//return sendRedirectToIndex(request, response);
			} else {
				System.out.println("拦截器,session为空，用户未登录！    StudentName:"+student.getName());
				return sendRedirectToError(request, response);
			}
		}
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	private boolean isExcludePath(String path) {
		if (this.excludePaths.contains(path)) {
			return true;
		}
		return false;
	}

	private boolean sendRedirectToError(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		StringBuffer sb = new StringBuffer(request.getContextPath());
		sb.append("/web/errorPermission");
		response.sendRedirect(sb.toString());
		return false;
	}
	private boolean sendRedirectToIndex(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		StringBuffer sb = new StringBuffer(request.getContextPath());
		sb.append("/web/index");
		response.sendRedirect(sb.toString());
		return false;
	}

	public List<String> getExcludePaths() {
		return excludePaths;
	}

	public void setExcludePaths(List<String> excludePaths) {
		this.excludePaths = excludePaths;
	}

}
