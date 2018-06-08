package com.tigers.controllers;

import com.tigers.models.Cart;
import com.tigers.models.Menu;
import com.tigers.services.MenuServices;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class orderConfirmController {

	Cart cart;
	
	@RequestMapping(value="/orderConfirm", method=RequestMethod.GET)
	public String menu(HttpSession session) {
		System.out.println("hi");
		System.out.println(session.getAttribute("currentUser"));
		cart = (Cart) session.getAttribute("cart");
		return "menu";
	}
	
	@ModelAttribute("order")
	public String orderItems() {
		System.out.println("trying");
		String c = cart.getItems().get(0).getName();
		
		return c;
		/*
		String order = "<table>";
		
		String orderTable = "<table id='currentOrder'>"
				+ "				<caption>Current Order</caption>"
				+ "				<tr>"
				+ "					<th>Item</th>"
				+ "					<th>Price</th>"
				+ "					<th>Qunatity</th>"
				+ "				</tr>";
		for(int index = 0; index < cart.getItems().size(); index++) {
			orderTable += "<tr> <td>" + cart.getItems().get(index).getName() + "</td><td>" + cart.getItems().get(index).getPrice() + "</td><td>" + 
						cart.getItems().get(index) + "</tr>";
			System.out.println("got order");
		}
		
		orderTable += "</table><br>Total price: " + cart.getTotalPrice();
		
		
		return order;
		*/
	}
	
	
}
