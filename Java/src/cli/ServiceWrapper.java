package cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


import domain.Card;


import domain.IdException;
import domain.User;
import services.UserService;

public class ServiceWrapper {
	
	Connection con;
	
	public ServiceWrapper() {
		super();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean login(String email, String password){
		
		UserService us = new UserService(con);
		User candidate = us.getByEmail(email);
		if(password == candidate.getPassword()) return true;
		else return false;
	}
	
	public boolean register(String userId, String firstName, String lastName, String email, String password, String userStatusId,
			String locationId){
		boolean result = false;
		try{
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

	
	//getUserCards is in cardsservices
	//getUserLocations is  in locationservices


}
