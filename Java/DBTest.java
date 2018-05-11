package CaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBTest {

	public static void main(String[] args) {
		
		testUserService();
		testUserStatusService();
		
	}
	
	static void testUserService(){
		Connection con;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "eric", "eric"); 
			System.out.println("Connection Successful");
			
			UserService us = new UserService(con);
			us.deleteUserById(0);
			
			ArrayList<User> users = us.getAllUsers();
			
			for(User user: users){
				System.out.println(user);
			}
			
			User usId = us.getUserById(0);
			System.out.println(usId);
						
			con.close();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	static void testUserStatusService(){
		Connection con;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "eric", "eric"); 
			System.out.println("Connection Successful");
			
			UserStatusService uss = new UserStatusService(con);
			uss.deleteUserStatusById(0);
			
			ArrayList<UserStatus> userStatuses = uss.getAllUserStatuses();
			
			for(UserStatus userStatus: userStatuses){
				System.out.println(userStatus);
			}
			
			UserStatus usSId = uss.getUserStatusById(0);
			System.out.println(usSId);
						
			con.close();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
