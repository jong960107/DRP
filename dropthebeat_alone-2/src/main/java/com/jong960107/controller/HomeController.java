package com.jong960107.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jong960107.beans.UserInfo;

@Controller
public class HomeController {

	@Resource(name="loginUserBean")
	private UserInfo loginUserBean;
	
	
	@GetMapping("/")
	public String home() {
		System.out.println(loginUserBean);
		return "redirect:main/index";
	}
	
}
