package com.jong960107;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jong960107.beans.BoardInfo;
import com.jong960107.beans.UserInfo;
import com.jong960107.interceptor.CheckLoginInterceptor;
import com.jong960107.interceptor.TopMenuInterceptor;
import com.jong960107.service.BoardService;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
	
	@Resource(name ="boardInfoBean")
	private BoardInfo boardInfoBean;
	
	@Resource(name ="loginUserBean")
	private UserInfo loginUserBean;
	
	@Resource(name ="boardInfoService")
	private BoardService boardInfoService;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new TopMenuInterceptor(loginUserBean,boardInfoBean,boardInfoService));
		
		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserBean, boardInfoBean);
		InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
		reg2.addPathPatterns("/user/modify","/user/logout","/board/*");
		reg2.excludePathPatterns("/board/free","/board/fun","/board/politics","/board/sport","/board/record");
	}

	
	
	@Bean("loginUserBean")
	@SessionScope
	public UserInfo loginUserBean() {
		return new UserInfo();
	}
	
	@Bean("boardInfoBean")
	@SessionScope
	public BoardInfo boardInfo() {
		return new BoardInfo();
	}
	
	@Bean("boardInfoService")
	@SessionScope
	public BoardService boardInfoService() {
		return new BoardService();
	}
	
	
}
