package cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


import domain.*;


import services.MenuServices;
import services.OrderService;
import services.UserService;

public class ServiceWrapper {
	
	Connection con;
	
	
	
	public ServiceWrapper(Connection con) {
		super();

	}

	public User login(String email, String password){
		
		UserService us = new UserService(con);
		User candidate = us.getByEmail(email);
		System.out.println(candidate.getFirstName());
		if(password.equals(candidate.getPassword())) return candidate;
		else return null;
	}
	
	public boolean register(String firstName, String lastName, String email, String password){
		//, String street, String city, String state, String country, String zip, String userStatus
		boolean result = false;
		String userId = Double.toString(Math.random()* 10001);
		String userStatusId = Double.toString(Math.random()* 10001);
		String locationId = Double.toString(Math.random()* 10001);
		User user = new User(userId,firstName,lastName,email,password,userStatusId,locationId);
		UserService us = new UserService(con);
		result =  us.add(user);
		return result;
	}

	public static void printOptions(ArrayList<String> options){
		options.add("Go back");
		options.add("Quit");
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println(count + ". " + option);
		}
		
	}
	
	public static void printMenuItems(ArrayList<Menu> menus){
		int count = 0;
		for(Menu menu: menus){
			count++;
			System.out.println(count + ". " + menu.getName());
		}
		System.out.println(++count + ". Go Back");
		System.out.println(++count + ". Quit");
	}

	public static void printOrders(ArrayList<Order> orders){
		int count = 0;
		for(Order order: orders){
			count++;
			System.out.println(count + ". " + order.getPlaced_timestamp());
		}
		System.out.println(count++ + ". Go Back");
		System.out.println(count++ + ". Quit");
	}

	public void cancelOrder(Order order) {
		order.setDelivery_status_id("3");
		OrderService os = new OrderService(con);
		os.update(order);
	}

	public void submitOrder(Order currentOrder) {
		// TODO Auto-generated method stub
		
		currentOrder.setDelivery_status_id("0");
		OrderService os = new OrderService(con);
		os.add(currentOrder);
		
	}

	public ArrayList<Menu> getMenuItems(ArrayList<String> itemIds) {
		
		MenuServices ms = new MenuServices(con);
		
		ArrayList<Menu> items = new ArrayList<Menu>();
		
		for (String itemId:itemIds){
			items.add(ms.getById(itemId));
		}
		
		return items;
	}
	public Order getOrCreateCurrentOrder(User currentUser) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
