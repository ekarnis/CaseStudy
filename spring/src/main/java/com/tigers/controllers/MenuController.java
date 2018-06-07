package com.tigers.controllers;
import com.tigers.models.Menu;
import com.tigers.services.MenuServices;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@ModelAttribute("items")
	public String menuItemsTable(){
		String itemTable = "<table> <tr><th>Item</th><th>Picture</th><th>Description</th><th>Price</th><th>Add</th></tr>";
		List<Menu> items = menServ.list();
		for(Menu item:items) {
			itemTable += "<tr><td>" + item.getName() + "</td><td><img src=\"" + item.getPhoto() + "\" width=\"150\"</td><td>" + 
						item.getDescription() + "</td><td>$" + item.getPrice() + "</td><td><button>Add</button></td></tr>";
		}
		
		itemTable += "</table>";
		
		return itemTable;
	}
	
}
