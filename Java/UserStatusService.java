package CaseStudy;

import java.sql.CallableStatement;
import java.sql.Connection;
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
	
	public void add(UserStatus userStatus){
		try{
			int userStatusId = userStatus.getUserStatusId();
			String userStatusName = userStatus.getUserStatus();
			
			CallableStatement oCSF = connection.prepareCall("{?=call sp_insert_user_status(?,?)}");
			oCSF.setInt(2,userStatusId);
			oCSF.setString(3, userStatusName);
			oCSF.execute();
			oCSF.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
	public void deleteById(int id){
		try{
			Statement usersSt = connection.createStatement();
			usersSt.executeQuery("Delete from user_statuses where user_status_id = "+id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public UserStatus getById(int id){
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
	public ArrayList<UserStatus> getAll(){
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
	public void updateById(UserStatus userStatus){
		try{
			int userStatusId = userStatus.getUserStatusId();
			String userStatusName = userStatus.getUserStatus();
			
			CallableStatement oCSF = connection.prepareCall("{?=call sp_update_user_status(?,?)}");
			oCSF.setInt(2,userStatusId);
			oCSF.setString(3, userStatusName);
			oCSF.execute();
			oCSF.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
}
