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
			us.deleteById("0");
			
			ArrayList<User> users = us.getAll();
			
			for(User user: users){
				System.out.println(user);
			}
			
			User usId = us.getById("0");
			System.out.println(usId);
			
			try{
				User user = new User("hey", "hi", "","","","","");
				us.add(user);
			}catch(IdException e){
				e.printStackTrace();
			}
						
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
			uss.deleteById(0);
			
			ArrayList<UserStatus> userStatuses = uss.getAll();
			
			for(UserStatus userStatus: userStatuses){
				System.out.println(userStatus);
			}
			
			UserStatus usSId = uss.getById(0);
			System.out.println(usSId);
			
			try{
				UserStatus userStatus = new UserStatus("hey", "hi");
				uss.add(userStatus);
			}catch(IdException e){
				e.printStackTrace();
			}

			con.close();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
