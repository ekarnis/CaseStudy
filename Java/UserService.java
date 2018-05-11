package CaseStudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserService {
	
	Connection connection;
	
	public UserService() {
		super();
	}
	public UserService(Connection connection) {
		super();
		this.connection = connection;
	}
	public void addUser(int userId, String firstName, String lastName, String email, String password, int userStatusId,
			int locationId){
		try{
			PreparedStatement oPS = connection.prepareStatement("insert into users values (?,?,?,?,?,?,?)");
			oPS.setInt(1, userId);
			oPS.setString(2, firstName);
			oPS.setString(3, lastName);
			oPS.setString(4, email);
			oPS.setString(5, password);
			oPS.setInt(6, userStatusId);
			oPS.setInt(7, locationId);
			oPS.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
	public void deleteUserById(int id){
		try{
			Statement usersSt = connection.createStatement();
			usersSt.executeQuery("Delete from users where user_id = "+id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<User> getAllUsers(){

		ArrayList<User> users = new ArrayList<User>();
		
		try{
			Statement usersSt = connection.createStatement();
			ResultSet usersRs = usersSt.executeQuery("Select * from Users");
			
			while(usersRs.next()){
				User user = new User(
						usersRs.getInt(1),
						usersRs.getString(2),
						usersRs.getString(3),
						usersRs.getString(4),
						usersRs.getString(5),
						usersRs.getInt(6),
						usersRs.getInt(7)
						); 
				users.add(user);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return users;
	}
	public User getUserById(int id){
		User user = null;
		
		try{
			Statement usersSt = connection.createStatement();
			ResultSet usersRs = usersSt.executeQuery("Select * from Users where user_id = " + id);
			
			usersRs.next();
			user = new User(
					usersRs.getInt(1),
					usersRs.getString(2),
					usersRs.getString(3),
					usersRs.getString(4),
					usersRs.getString(5),
					usersRs.getInt(6),
					usersRs.getInt(7)
					); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
		
		return user;
	}
	
	
}
