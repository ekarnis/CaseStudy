package com.tigers.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tigers.models.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String login(ModelMap model) {
		User user = new User();
        model.addAttribute("user", user);
        System.out.println("Created user object for login");
        return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String loginSubmit(@Valid User user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
            System.out.println("There were some errors");
            //return "register";
		}
        System.out.println("Login should be successful");
        
        // method calls here for submitting user information?
        // create temp user based on return of getByEmail, check if null, and proceed if valid; otherwise give an error
        System.out.println("email: " + user.getEmail() + " and pass: " + user.getPassword());
        
        
        return "login"; // loginSuccess page/session home page?
	}
	
	
}
