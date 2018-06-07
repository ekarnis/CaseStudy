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
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private UserService userService;
	
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
            return "login";
		}
        System.out.println("email: " + user.getEmail() + " and pass: " + user.getPassword());
        //TODO:  use userService.getUserByEmail(email) to verify login information
        //       build the user object in order to create a session
        
        //TODO:  return to home page with user session info
        return "home";
	}
}
