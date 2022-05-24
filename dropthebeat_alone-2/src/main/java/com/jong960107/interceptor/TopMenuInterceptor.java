package com.jong960107.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jong960107.beans.UserInfo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TopMenuInterceptor implements HandlerInterceptor{
	
	@Resource(name ="loginUserBean")
	private UserInfo loginUserBean;
	
	public TopMenuInterceptor(UserInfo loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("loginUserBean", loginUserBean);
		
		return true;
	}
	
}
