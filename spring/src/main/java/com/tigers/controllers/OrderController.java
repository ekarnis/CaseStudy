package com.tigers.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tigers.models.Order;
import com.tigers.models.User;
import com.tigers.services.OrderService;


@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
    private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showOrders() {
        return "orders";
	}
	
	@ModelAttribute("completedOrders")
	public String completeOrdersTable(HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		
		String orderTable = "<table>"
				+ "				<tr>"
				+ "					<th>OrderId</th>"
				+ "					<th>Total</th>"
				+ "					<th>Date Ordered</th>"
				+ "					<th>Date Delivered</th>"
				+ "					<th>Instructions</th>"
				+ "				</tr>";
		
		List<Order> orders = orderService.list(user.getUserId());
		
		for(Order order : orders) {
			// deliveryStatusId of "2" := "delivered"
			if(order.getDeliveryStatusId().equals("2")) {
				orderTable +=	"<tr>"
						+ "			<td>" + order.getOrderId() + "</td>"
						+ "			<td>" + order.getTotalPrice() + "</td>"
						+ "			<td>" + order.getPlacedTimestamp() + "</td>"
						+ "			<td>" + order.getDeliveryTimestamp() + "</td>"
						+ "			<td>" + order.getInstuctions() + "</td>"
						+ "		</tr>";
			}
		}
		orderTable += "</table>";
		
		return orderTable;
	}
}
