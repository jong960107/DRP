package com.jong960107.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/main2")
public class MainController2 {

	@GetMapping("/index2")
	public String main2() {
		return "main2/index2";
	}
	
}
