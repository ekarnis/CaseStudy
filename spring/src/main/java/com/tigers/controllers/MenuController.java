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
import org.springframework.web.bind.annotation.PathVariable;
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
		String itemTable = "<div id=\"form_containe\"><form:form method=\"POST\" modelAttribute=\"user\" class=\"form-horizontal\">"
				+ "<table> <tr><th>Item</th><th>Picture</th><th>Description</th><th>Price</th><th>Add</th></tr>";
		List<Menu> items = menServ.list();
		for(Menu item:items) {
			itemTable += "<form method='POST' class=\\\"form-horizontal\\\"><tr><td>" + item.getName() + "</td><td><img src=\"" + item.getPhoto() + "\" width=\"150\"</td><td>" + 
						item.getDescription() + "</td><td>$" + item.getPrice() + "</td><td><input type=\"submit\" path=" + item.getId() + " name=" + item.getId() + " value=\"Add\"></td></tr></form>";
		}
		
		itemTable += "</table></div id=\"form_container\">";
		
		return itemTable;
	}
	
	@RequestMapping(value="add/{id}")
	public void addItem(@PathVariable("id") String id) {
		System.out.println("id is " + id);
	}
	
}
