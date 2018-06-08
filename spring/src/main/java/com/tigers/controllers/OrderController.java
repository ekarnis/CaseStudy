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
	
	@ModelAttribute("pendingOrders")
	public String pendingOrdersTable(HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		
		String orderTable = "<table id='pendingOrders' class='orderTable'>"
				+ "				<caption>Pending Orders</caption>"
				+ "				<tr>"
				+ "					<th>OrderId</th>"
				+ "					<th>Total</th>"
				+ "					<th>Date Ordered</th>"
				+ "					<th>Date Delivered</th>"
				+ "					<th>Instructions</th>"
				+ "					<th>Order Status</th>"
				+ "				</tr>";
		
		List<Order> orders = orderService.list(user.getUserId());
		
		for(Order order : orders) {
			// deliveryStatusId of "0" := "pending"
			// deliveryStatusId of "1" := "on delivery"
			String statusId = order.getDeliveryStatusId();
			String orderStatus;
			
			if(statusId.equals("0")) {
				orderStatus = "pending";
			}
			else {
				orderStatus = "on delivery";
			}
			
			if(statusId.equals("0") || statusId.equals("1")) {
				orderTable +="	<tr>"
						+ "			<td>" + order.getOrderId() + "</td>"
						+ "			<td>" + order.getTotalPrice() + "</td>"
						+ "			<td>" + order.getPlacedTimestamp() + "</td>"
						+ "			<td>" + order.getDeliveryTimestamp() + "</td>"
						+ "			<td>" + order.getInstuctions() + "</td>"
						+ "			<td>" + orderStatus + "</td>"
						+ "		</tr>";
			}
		}
		orderTable += "		</table>";
		
		return orderTable;
	}
	
	@ModelAttribute("completedOrders")
	public String completeOrdersTable(HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		
		String orderTable = "<table id='completedOrders' class='orderTable'>"
				+ "				<caption>Completed Orders</caption>"
				+ "				<tr>"
				+ "					<th>OrderId</th>"
				+ "					<th>Total</th>"
				+ "					<th>Date Ordered</th>"
				+ "					<th>Date Delivered</th>"
				+ "					<th>Instructions</th>"
				+ "					<th>Order Status</th>"
				+ "				</tr>";
		
		List<Order> orders = orderService.list(user.getUserId());
		
		for(Order order : orders) {
			// deliveryStatusId of "2" := "delivered"
			// deliveryStatusId of "3" := "cancelled"
			String statusId = order.getDeliveryStatusId();
			String orderStatus;
			
			if(statusId.equals("2")) {
				orderStatus = "delivered";
			}
			else {
				orderStatus = "cancelled";
			}
			
			if(statusId.equals("2") || statusId.equals("3")) {
				orderTable +=	"<tr>"
						+ "			<td>" + order.getOrderId() + "</td>"
						+ "			<td>" + order.getTotalPrice() + "</td>"
						+ "			<td>" + order.getPlacedTimestamp() + "</td>"
						+ "			<td>" + order.getDeliveryTimestamp() + "</td>"
						+ "			<td>" + order.getInstuctions() + "</td>"
						+ "			<td>" + orderStatus + "</td>"
						+ "		</tr>";
			}
		}
		orderTable += "</table>";
		
		return orderTable;
	}
}
