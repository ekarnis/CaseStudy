package com.tigers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tigers.models.User;
import com.tigers.services.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String register(ModelMap model) {
		User user = new User();
        model.addAttribute("user", user);
        System.out.println("Created user object for register");
        return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String registerSubmit(@Valid User user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
            System.out.println("There were some errors");
            //return "register";
		}
        userService.add(user);
        return "home";
	}
}
