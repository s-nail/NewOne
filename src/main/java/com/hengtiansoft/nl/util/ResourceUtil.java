package com.hengtiansoft.nl.util;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

/**Title: 上下文、资源文件处理工具 
* Description: 上下文、资源文件处理工具 
* Copyright: Copyright (c) 2003 
* Company:Hengtian Software Ltd. 
* @author huironglou(Fyeman) 
* @version 1.0 
*/
public class ResourceUtil {
	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("nl");
	/**
	 * 获得请求路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		requestPath = requestPath.substring(request.getContextPath().length() + 1);// 去掉项目路径
		return requestPath;
	}
	
	/**
	 * 获取配置文件参数
	 * 
	 * @param name
	 * @return
	 */
	public static final String getConfigByName(String name) {
		return bundle.getString(name);
	}
}
