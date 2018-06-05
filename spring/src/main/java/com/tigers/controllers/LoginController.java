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
            //return "registration";
		}
        System.out.println("Login should be successful");
        
        // method calls here for submitting user information?
        // create temp user based on return of getByEmail, check if null, and proceed if valid; otherwise give an error
        System.out.println("email: " + user.getEmail() + " and pass: " + user.getPassword());
        
        
        User testUser = new User("6","Salad","Manlet","6666665544","salad2@gmail.com","pass","2");
        //UserService userService = new UserService();
        
        System.out.println("Trying to add user");
        userService.add(testUser);
        
        
        return "login"; // loginSuccess page/session home page?
	}
	
	
}
