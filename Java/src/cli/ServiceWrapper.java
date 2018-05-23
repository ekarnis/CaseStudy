package cli;

import java.sql.Connection;

import domain.IdException;
import domain.User;
import services.UserService;

public class ServiceWrapper {
	
	Connection con;
	
	public ServiceWrapper(Connection con) {
		super();
		this.con = con;
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

}
