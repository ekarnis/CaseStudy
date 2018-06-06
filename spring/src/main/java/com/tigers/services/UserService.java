package com.tigers.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tigers.models.User;

// should use @Service tag
@Component
public class UserService implements Service<User> {
	
	@Autowired
	JdbcTemplate jTemp;
	
	Connection connection;
	
	public UserService(Connection connection) {
		super();

	}
	
	
	@Override
	public void add(User user){
		try {
			String userId = getPK();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String phone = user.getPhoneNumber();
			String email = user.getEmail();
			String password = user.getPassword();
			String userStatusId = user.getUserStatusId();
			
			String query = "{CALL sp_insert_user(?,?,?,?,?,?,?)}";
			
			jdbcTemplate.update(query, userId, firstName, lastName, phone, email, password, userStatusId);
			System.out.println("UserService:  User added.");
		} catch(Exception e) {
			System.out.println("UserService:  Failed to add user.");
			System.out.println(e.getMessage());
		}	

	}
	
	
	/*
	 * Delete an existing user by user id
	 */
	@Override
	public void delete(String id){
		String query = "DELETE FROM Users WHERE Users.user_id LIKE ?";
		jdbcTemplate.update(query, id);
	}
	
	
	/*
	 * Return List of all existing users
	 */
	@Override
	public List<User> list(){
		String query = "SELECT * FROM Users";
		List<User> users = jdbcTemplate.query(query, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setFirstName(rs.getString("first"));
				user.setLastName(rs.getString("last"));
				user.setPhoneNumber(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserStatusId(rs.getString("user_status_id"));
				
				return user;
			}
		});
		
		return users;
	}
	
	
	/*
	 * Return user object by user id
	 */
	@Override
	public User get(String id){
		String query = "SELECT * FROM Users WHERE Users.user_id LIKE '" + id + "'";
		
		try{
			Statement usersSt = connection.createStatement();
			ResultSet usersRs = usersSt.executeQuery("Select * from Users");
			

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					User user = new User();
					user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first"));
					user.setLastName(rs.getString("last"));
					user.setPhoneNumber(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setUserStatusId(rs.getString("user_status_id"));
					
					return user;
				}
				return null;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return users;
	}

	/*
	 * Return user object by email
	 */
	public User getUserByEmail(String email){
		String query = "SELECT * FROM Users WHERE Users.email LIKE '" + email + "'";
		
		try{
			Statement usersSt = connection.createStatement();
			ResultSet usersRs = usersSt.executeQuery("Select * from Users where user_id = " + id);
			

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					User user = new User();
					user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first"));
					user.setLastName(rs.getString("last"));
					user.setPhoneNumber(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setUserStatusId(rs.getString("user_status_id"));
					
					return user;
				}
				return null;
			}
		});
	}
	
	
	/*
	 * Update an existing user with new user values
	 */
	public void update(User user) {
		String userId = user.getUserId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String phone = user.getPhoneNumber();
		String email = user.getEmail();
		String password = user.getPassword();
		String userStatusId = user.getUserStatusId();
		
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
	}
	
	
	/*
	 * Gets a new, unique userId based on Unix time in string format
	 */
	private String getPK() {
		long unixTime = System.currentTimeMillis() / 1000L;
		return "" + unixTime;
	}
}
