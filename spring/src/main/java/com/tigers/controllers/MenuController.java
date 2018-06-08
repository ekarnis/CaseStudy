package com.tigers.controllers;
import com.tigers.models.Menu;
import com.tigers.services.MenuServices;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

	@Autowired
    private MenuServices menServ;
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menu(HttpSession session) {
		System.out.println(session.getAttribute("currentUser"));
		List<Menu> items = menServ.list();
		System.out.println(items.toString());
		return "menu";
	}
	
	@RequestMapping(value="/menu", method=RequestMethod.POST)
	public String menuSubmit(ModelMap model, HttpSession session, HttpServletRequest test) {
		System.out.println("Model is: " + model);
		//System.out.println("request is: " + test.get;
		String meal_id = test.getParameterNames().nextElement();
		System.out.println(meal_id);

		
		//Enumeration<String> test2 = test.getParameterNames();
		//while(test2.hasMoreElements());
			   //System.out.println(test2.nextElement());
		//System.out.println(test.)
		//System.out.println("request is: " + test.getParameter("1"));
		
		
		System.out.println(session.getAttribute("currentUser"));
		//List<Menu> items = menServ.list();
		//System.out.println(items.toString());
		return "menu";
	}
	
	@ModelAttribute("items")
	public String menuItemsTable() {
		String itemTable = "<table>";
		List<Menu> items = menServ.list();
		// <img src=\"" + item.getPhoto() + 
		for(Menu item:items) {
			itemTable += "<form method='POST' class=\"form-horizontal\"><tr class=\"mealRow\"><td class=\"mealName\">" + item.getName() + "</td><td class=\"mealPhoto\"><img src=\"/images/stockMeal.jpg" + "\" width=\"150\"</td><td class=\"mealDescription\">" + 
						item.getDescription() + "</td><td class=\"mealPrice\">$" + item.getPrice() + "</td><td class=\"mealAdd\"><input type=\"submit\" path=" + item.getId() + " name=" + item.getId() + " value=\"Add\"></td></tr></form>";
		}
		
		itemTable += "</table>";
		
		return itemTable;
	}
	
}
