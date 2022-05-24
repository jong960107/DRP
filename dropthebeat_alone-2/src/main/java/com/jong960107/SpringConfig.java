package com.jong960107;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jong960107.beans.UserInfo;
import com.jong960107.interceptor.CheckLoginInterceptor;
import com.jong960107.interceptor.TopMenuInterceptor;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
	
	@Resource(name ="loginUserBean")
	private UserInfo loginUserBean;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new TopMenuInterceptor(loginUserBean));
		
		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserBean);
		InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
		reg2.addPathPatterns("/user/modify","/user/logout");
		reg2.excludePathPatterns("/board/main");
	}

	
	
	@Bean("loginUserBean")
	@SessionScope
	public UserInfo loginUserBean() {
		return new UserInfo();
	}
	
}
