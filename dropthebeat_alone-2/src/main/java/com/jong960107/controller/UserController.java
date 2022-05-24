package com.jong960107.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jong960107.beans.UserInfo;
import com.jong960107.service.UserService;
import com.jong960107.validator.UserValidator;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@Resource(name="loginUserBean")
	private UserInfo loginUserBean;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("loginUserInfo") UserInfo loginUserInfo,
									@RequestParam(value="fail" ,defaultValue = "false") boolean  fail,Model model) {
		
		model.addAttribute("fail",fail);
		
		return "user/login";
	}
	
	@PostMapping("/loginPro")
	public String loginPro(@Valid @ModelAttribute("loginUserInfo") UserInfo loginUserInfo ,BindingResult result) {
		if(result.hasErrors()) {
			
			System.out.println(result);
			
			return "user/login";
		}			
			userService.getLoginUserInfo(loginUserInfo);

		if(loginUserBean.isUserLogin()==true){
			return "user/loginSuccess";
		} else {
			return "user/loginFail";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		
		loginUserBean.setUserLogin(false);
		
		return "user/logout";
	}
	
	@GetMapping("/not_login")
	public String not_login() {
		return "user/not_login";
	}
	
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserInfo2") UserInfo modifyUserInfo2) {
		
		userService.getModifyUserInfo2(modifyUserInfo2);

		
		return "user/modify";
	}
	
	@PostMapping("/modifyPro")
	public String modifyPro(@Valid @ModelAttribute("modifyUserInfo2") UserInfo modifyUserInfo2,BindingResult result) {
		
			if(result.hasErrors()) {
			
			return "user/modify";
			
		}
			userService.modifyUserInfo2(modifyUserInfo2);
			return "user/modifySuccess";
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
		

		userService.addUserInfo(modifyUserInfo);
		
		return "user/signupSuccess";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		UserValidator validator1 = new UserValidator();
		webDataBinder.addValidators(validator1);
	}
	
}
