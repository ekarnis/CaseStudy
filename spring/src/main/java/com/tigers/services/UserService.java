package com.tigers.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.tigers.models.User;


public class UserService implements Service<User>{
	
	private JdbcTemplate jdbcTemplate;
	
	public UserService(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	/*
	 * Add a new user object
	 */
	@Override
	public void add(User user){
		String userId = user.getUserId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String phone = user.getPhoneNumber();
		String email = user.getEmail();
		String password = user.getPassword();
		String userStatusId = user.getUserStatusId();
		
		long unixTime = System.currentTimeMillis() / 1000L;
		userId = "" + unixTime;
		
		String query = "{CALL sp_insert_user(?,?,?,?,?,?,?)}";
		
		jdbcTemplate.update(query, userId, firstName, lastName,
							phone, email, password, userStatusId);
	}
	
	
	/*
	 * Delete an existing user by user id
	 */
	@Override
	public void delete(String id){
		String query = "DELETE FROM Users WHERE Users.user_id = ?";
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
		String query = "SELECT * FROM Users WHERE User.user_id = " + id;
		
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
			
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
	 * Return user object by email
	 */
	public User getUserByEmail(String email){
		String query = "SELECT * FROM Users WHERE User.email = " + email;
		
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
			
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
		
		String query = "{CALL sp_update_user(?,?,?,?,?,?,?)}";
		
		jdbcTemplate.update(query, userId, firstName, lastName,
							phone, email, password, userStatusId);
	}
}
