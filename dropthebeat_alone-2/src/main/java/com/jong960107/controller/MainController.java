package com.jong960107.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/main")
public class MainController {

	@GetMapping("index")
	public String main(){
		return "main/index";
	}
	
	
	
}
