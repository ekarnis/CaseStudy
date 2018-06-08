package com.tigers.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tigers.models.User;
import com.tigers.services.UserService;

@Controller
public class AccountController { 
	
	@Autowired
    private UserService userService;
	
	@RequestMapping("/account")
	public String index(ModelMap model, HttpSession session) {
		if (session.getAttribute("currentUser") == null)
		{
			System.out.println("session is null");
		}
		System.out.println(session.getAttribute("currentUser"));
		
		// tempUser = (User) session.getAttribute("currentUser");
		
		//model.addAttribute("user", tempUser);
		
		return "account";
	}
	
	// need to put this Url behind a session
	@RequestMapping(value="/account/accountEdit", method=RequestMethod.GET)
	public String accountEdit(ModelMap model, HttpSession session) {
		User user = new User();
        model.addAttribute("newUser", user);
		if (session.getAttribute("currentUser") == null)
		{
			System.out.println("session is null");
		}
		System.out.println(session.getAttribute("currentUser"));
		
		//User tempUser = (User) session.getAttribute("currentUser");
		
		//model.addAttribute("user", tempUser);
		
		
		return "accountEdit";
	}
	
	@RequestMapping(value="/account/accountEdit", method=RequestMethod.POST)
	public String accountEditSubmit(@Valid User user, ModelMap model, HttpSession session) {
		if (session.getAttribute("currentUser") == null)
		{
			System.out.println("session is null");
		}
		System.out.println(session.getAttribute("currentUser"));
		
		User tempUser = (User) session.getAttribute("currentUser");
		
		tempUser.setEmail(user.getEmail()); // assumes new email (if set) is unique or error should be thrown
		if (user.getPassword().isEmpty()) 
		{
			// do nothing; should prompt user that password wasn't entered or doesn't match
		}
		else {
			tempUser.setPassword(user.getPassword());
		}
		tempUser.setPassword(user.getPassword()); // assumes password and confirm password match
		tempUser.setFirstName(user.getFirstName());
		tempUser.setLastName(user.getLastName());
		tempUser.setPhoneNumber(user.getPhoneNumber());
		
		// update user in DB; check if it went through?
		userService.update(tempUser);
		
		
		// update user in session (assuming user was updated successfully)
		// this could be done within update method but would have to pass session in and violate/change interface without making new function
		session.setAttribute("currentUser", tempUser);
		
		// ideally would throw success message
		return "redirect:/account";
	}
}