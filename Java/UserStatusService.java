package CaseStudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserStatusService {

	
	Connection connection;
	
	public UserStatusService() {
		super();
	}
	public UserStatusService(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void addUserStatus(int userStatusId, String userStatus){
		try{
			PreparedStatement oPS = connection.prepareStatement("insert into users values (?,?,?,?,?,?,?)");
			oPS.setInt(1, userStatusId);
			oPS.setString(2, userStatus);
			oPS.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
	public void deleteUserStatusById(int id){
		try{
			Statement usersSt = connection.createStatement();
			usersSt.executeQuery("Delete from user_statuses where user_status_id = "+id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public UserStatus getUserStatusById(int id){
		UserStatus userStatus = null;
		
		try{
			Statement usersSt = connection.createStatement();
			ResultSet usersRs = usersSt.executeQuery("Select * from Users where user_id = " + id);
			
			usersRs.next();
			userStatus = new UserStatus(
					usersRs.getInt(1),
					usersRs.getString(2)
					); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
		
		return userStatus;
	}
	public ArrayList<UserStatus> getAllUserStatuses(){
		ArrayList<UserStatus> userStatuses = new ArrayList<UserStatus>();
		
		try{
			Statement userStatusesSt = connection.createStatement();
			ResultSet userStatusesRs = userStatusesSt.executeQuery("Select * from Users");
			
			while(userStatusesRs.next()){
				UserStatus userStatus = new UserStatus(
						userStatusesRs.getInt(1),
						userStatusesRs.getString(2)
						); 
				userStatuses.add(userStatus);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return userStatuses;
	}
	
}
