package com.jong960107.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jong960107.beans.UserInfo;

@Controller
public class HomeController {

	@Resource(name="loginUserBean")
	private UserInfo loginUserBean;
	
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
//		System.out.println(loginUserBean);
//		System.out.println(request.getServletContext().getRealPath("/"));
		return "redirect:main/index";
	}
	
	
}
