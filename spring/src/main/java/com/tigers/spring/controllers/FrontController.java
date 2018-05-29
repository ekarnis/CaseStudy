package com.tigers.spring.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class FrontController implements ErrorController {
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		System.out.println("Trying to return index page");
		return "index";
	}
	
	//@RequestMapping(value="/error")
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	
	
	
}
