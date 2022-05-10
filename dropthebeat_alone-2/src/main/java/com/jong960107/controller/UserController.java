package com.jong960107.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jong960107.beans.UserInfo;
import com.jong960107.validator.UserValidator;

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
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		UserValidator validator1 = new UserValidator();
		webDataBinder.addValidators(validator1);
	}
	
}
