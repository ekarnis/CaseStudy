package services;

public class ServiceWrapper {
	
	public Boolean login(String email, String password){
		
		
		
		return true;
	}
	
	public Boolean register(String userId, String firstName, String lastName, String email, String password, String userStatusId,
			String locationId){
		Boolean result = false;
		try{
			User user = new User(userId,firstName,lastName,email,password,userStatusId,locationId);
			UserService us = new UserService();
			result =  us.add(user);
		}catch(IdException idEx){
			System.out.println(idEx);
		}
		
		return result;
		
	}

}
