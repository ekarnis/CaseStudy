package com.tigers.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController { 
	
	@RequestMapping("/contact")
	public String index(HttpSession session) {
		if (session.getAttribute("currentUser") == null)
		{
			System.out.println("session is null");
		}
		System.out.println(session.getAttribute("currentUser"));
		return "contact";
	}
}