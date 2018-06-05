package com.tigers.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.tigers.models.User;

// should use @Service tag
@Component
public class UserService implements Service<User>{
	
	//Connection connection;
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public UserService() {
		super();
		//this.connection = connection;
	}
	public boolean add(User user){
		try{
			
			String userId = user.getUserId();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String phone = user.getPhone();
			String email = user.getEmail();
			String password = user.getPassword();
			String userStatusId = user.getUserStatusId();
			
			/*
			jdbcTemplate = new JdbcTemplate();
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	        dataSource.setUsername("db_uSpring");
	        dataSource.setPassword("pass");      
			jdbcTemplate.setDataSource(dataSource);*/
			System.out.println("About to print jdbctemplate");
			System.out.println(jdbcTemplate.getDataSource());
			System.out.println(jdbcTemplate);
			System.out.println("Should have printed jdbctemplate");
			jdbcTemplate.update("call sp_insert_user(?,?,?,?,?,?,?)", userId, firstName, lastName, phone, email, password, userStatusId);
			
			return true;
		}catch(Exception e){
			System.out.println("error");
			System.out.println(e.getMessage());
			return false;
		}	
	}/*
	public void deleteById(String id){
		try{
			Statement usersSt = connection.createStatement();
			usersSt.executeQuery("Delete from users where user_id = "+id);
		}catch(SQLException e){
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
						usersRs.getString(1),
						usersRs.getString(2),
						usersRs.getString(3),
						usersRs.getString(4),
						usersRs.getString(5),
						usersRs.getString(6),
						usersRs.getString(7)
						); 
				users.add(user);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return users;
	}
	public User getById(String id){
		User user = null;
		
		try{
			Statement usersSt = connection.createStatement();
			ResultSet usersRs = usersSt.executeQuery("Select * from Users where user_id = " + id);
			
			usersRs.next();
			user = new User(
					usersRs.getString(1),
					usersRs.getString(2),
					usersRs.getString(3),
					usersRs.getString(4),
					usersRs.getString(5),
					usersRs.getString(6),
					usersRs.getString(7)
					); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
		
		return user;
	}
	
	public User getByEmail(String email){
		User user = null;
		
		try{
			
			PreparedStatement pstmt = connection.prepareStatement("select * from users "
					+ "where email = ?"); 
			pstmt.setString(1,email);
						
			ResultSet usersRs = pstmt.executeQuery();
			
			usersRs.next();
			user = new User(
					usersRs.getString(1),
					usersRs.getString(2),
					usersRs.getString(3),
					usersRs.getString(4),
					usersRs.getString(5),
					usersRs.getString(6),
					usersRs.getString(7)
					); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
		
		return user;
	}
	public void update(User user){
		try{
			String userId = user.getUserId();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String phone = user.getPhone();
			String email = user.getEmail();
			String password = user.getPassword();
			String userStatusId = user.getUserStatusId();
			
			CallableStatement oCSF = connection.prepareCall("{call sp_update_user(?,?,?,?,?,?,?)}");
			oCSF.setString(1, userId);
			oCSF.setString(2, firstName);
			oCSF.setString(3, lastName);
			oCSF.setString(4, phone);
			oCSF.setString(5, email);
			oCSF.setString(6, password);
			oCSF.setString(7, userStatusId);
			oCSF.execute();
			oCSF.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}	
	}*/
	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(User obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
