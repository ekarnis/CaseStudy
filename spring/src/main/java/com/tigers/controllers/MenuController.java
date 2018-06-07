package com.tigers.controllers;
import com.tigers.models.Menu;
import com.tigers.services.MenuServices;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tigers.services.UserService;

@Controller
public class MenuController {

	@Autowired
    private MenuServices menServ;
	
	@RequestMapping("/menu")
	public String index(HttpSession session) {
		System.out.println(session.getAttribute("currentUser"));
		List<Menu> items = menServ.list();
		System.out.println(items.toString());
		return "menu";
	}
	
}
