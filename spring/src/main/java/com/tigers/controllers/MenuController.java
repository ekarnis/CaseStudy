package com.tigers.controllers;
import com.tigers.services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tigers.services.UserService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
    private MenuServices menServ;
	
	
}
