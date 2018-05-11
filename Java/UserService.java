package CaseStudy;

import java.sql.CallableStatement;
import java.sql.Connection;
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
	public void add(User user){
		try{
			int userId = user.getUserId();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String email = user.getEmail();
			String password = user.getPassword();
			int userStatusId = user.getUserStatusId();
			int locationId = user.getLocationId();
			
			CallableStatement oCSF = connection.prepareCall("{?=call sp_insert_user(?,?,?,?,?,?,?)}");
			oCSF.setInt(2, userId);
			oCSF.setString(3, firstName);
			oCSF.setString(4, lastName);
			oCSF.setString(5, email);
			oCSF.setString(6, password);
			oCSF.setInt(7, userStatusId);
			oCSF.setInt(8, locationId);
			oCSF.execute();
			oCSF.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
	public void deleteById(int id){
		try{
			Statement usersSt = connection.createStatement();
			usersSt.executeQuery("Delete from users where user_id = "+id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<User> getAll(){

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
	public User getById(int id){
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
	public void UpdateById(User user){
		try{
			int userId = user.getUserId();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String email = user.getEmail();
			String password = user.getPassword();
			int userStatusId = user.getUserStatusId();
			int locationId = user.getLocationId();
			
			CallableStatement oCSF = connection.prepareCall("{?=call sp_update_user(?,?,?,?,?,?,?)}");
			oCSF.setInt(2, userId);
			oCSF.setString(3, firstName);
			oCSF.setString(4, lastName);
			oCSF.setString(5, email);
			oCSF.setString(6, password);
			oCSF.setInt(7, userStatusId);
			oCSF.setInt(8, locationId);
			oCSF.execute();
			oCSF.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
	
	
}
