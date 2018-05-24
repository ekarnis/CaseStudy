package cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


import domain.Card;


import domain.IdException;
import domain.Menu;
import domain.User;
import services.UserService;

public class ServiceWrapper {
	
	Connection con;
	
	
	
	public ServiceWrapper(Connection con) {
		super();

	}

	public Boolean login(String email, String password){
		
		UserService us = new UserService(con);
		User candidate = us.getByEmail(email);
		if(password == candidate.getPassword()) return true;
		else return false;
	}
	
	public boolean register(String firstName, String lastName, String email, String password, String street, String city, String state, String country, String zip, String userStatus){
		boolean result = false;
		try{
			String userId = Double.toString(Math.random()* 10001);
			String userStatusId = Double.toString(Math.random()* 10001);
			String locationId = Double.toString(Math.random()* 10001);
			User user = new User(userId,firstName,lastName,email,password,userStatusId,locationId);
			UserService us = new UserService(con);
			result =  us.add(user);
		}catch(IdException idEx){
			System.out.println(idEx);
		}
		return result;
	}

	public static void printOptions(ArrayList<String> options){
		options.add("Go back");
		options.add("Quit");
		int count = 0;
		for(String option : options) {
			count++;
			System.out.println("\n" + count + ". " + option);
		}
		
	}
	
	public static void printMenuOptions(ArrayList<Menu> menus){
		int count = 0;
		for(Menu menu: menus){
			count++;
			System.out.println(count + menu.getName());
		}
		System.out.println(count++ + "Go Back");
		System.out.println(count++ + "Go Quit");
	}


	
	//getUserCards is in cardsservices
	//getUserLocations is  in locationservices


}
