package com.jong960107.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jong960107.beans.UserInfo;

public class CheckLoginInterceptor implements HandlerInterceptor{

	private UserInfo loginUserBean;

	public CheckLoginInterceptor(UserInfo loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		if(loginUserBean.isUserLogin() == false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/user/not_login");
			return false;
		}
		
		return true;
	}
	
	
}
