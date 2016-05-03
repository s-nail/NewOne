package com.hengtiansoft.nl.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hengtiansoft.nl.util.ResourceUtil;

public class SecurityInterceptor implements HandlerInterceptor {
	private List<String> excludePaths;

	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("SecurityInterceptor preHandle");

		String requestPath = ResourceUtil.getRequestPath(request);
		String lastPath = requestPath
				.substring(requestPath.lastIndexOf("/") + 1);
		System.out.println(lastPath);
		if (isExcludePath(lastPath)) {
			System.out.println("进来了" + lastPath);
			return true;
		}else {
			sendRedirectToError(request, response);
		}
		return false;
	}

	
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	private boolean isExcludePath(String path) {
		if (this.excludePaths.contains(path)) {
			return true;
		}
		return false;
	}

	private boolean sendRedirectToError(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		StringBuffer sb=new StringBuffer(request.getContextPath());		
		sb.append("/web/errorPermission");
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
