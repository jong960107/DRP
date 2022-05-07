package com.jong960107.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jong960107.beans.UserInfo;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/signup")
	public String signup(@ModelAttribute("modifyUserInfo") UserInfo modifyUserInfo) {
		return "user/signup";
	}
	
	@PostMapping("/signupPro")
	public String signupPro(@Valid @ModelAttribute("modifyUserInfo") UserInfo modifyUserInfo ,BindingResult result) {
	
		if(result.hasErrors()) {
			return "user/signup";
		}
		return "user/signupSuccess";
	}
	
}
