package com.jong960107.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jong960107.beans.BoardInfo;
import com.jong960107.beans.UserInfo;
import com.jong960107.service.BoardService;

public class CheckLoginInterceptor implements HandlerInterceptor{

	
	
	@Resource(name = "loginUserBean")
	private UserInfo loginUserBean;


	
	public CheckLoginInterceptor(UserInfo loginUserBean, BoardInfo boardInfoBean) {
		super();
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
