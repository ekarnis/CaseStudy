package com.tigers.services;
import com.tigers.models.Menu;
import com.tigers.models.TimeSlots;
import com.tigers.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MenuServices implements Service<Menu> {
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public MenuServices() {
		super();
	}

	@Override
	public Menu get(String id){	
		
		String query = "SELECT * FROM items WHERE item_id = ?";
		
		return jdbcTemplate.query(query, new ResultSetExtractor<Menu>() {
			@Override
			public Menu extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Menu men = new Menu();
					men.setId(rs.getString("item_id"));
					men.setName(rs.getString("name"));
					men.setDescription(rs.getString("description"));
					men.setPhoto(rs.getString("photo"));
					men.setPrice(rs.getFloat("price"));
					men.setSlot_ID(rs.getString("time_slot_id"));
					men.setType(rs.getString("item_type_id"));
					men.setVegetarian(rs.getString("vegetarian").charAt(0));
					
					return men;
				}
				return null;
			}
		});
		
		
	}

	@Override
	public List<Menu> list(){
		
		String query = "SELECT * FROM Items";
		List<Menu> menArr = jdbcTemplate.query(query, new RowMapper<Menu>() {

			@Override
			public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
				Menu men = new Menu();
				men.setId(rs.getString("item_id"));
				men.setName(rs.getString("name"));
				men.setDescription(rs.getString("description"));
				men.setPhoto(rs.getString("photo"));
				men.setPrice(rs.getFloat("price"));
				men.setSlot_ID(rs.getString("time_slot_id"));
				men.setType(rs.getString("item_type_id"));
				men.setVegetarian(rs.getString("vegetarian").charAt(0));
				
				return men;
			}
		});
		
		return menArr;
		
		
		
	}
	
	
	public void add(Menu men){		
		
		String id = men.getId();
		String name = men.getName();
		String veg = men.getVegetarian() + "";
		String type = men.getType();
		String desc = men.getDescription();
		String time = men.getSlot_ID();
		String pic = men.getPhoto();
		float price = men.getPrice();
		
		String query = "insert into items values(?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(query, id, name, veg, type, desc, time, pic, price);
		
	}
	
	public void delete(String id){
		String query = "DELETE FROM items WHERE item_id = ?";
		jdbcTemplate.update(query, id);
	}
	
	@Override
	public void update(Menu men){
		//ArrayList<TimeSlots> times = timServ.list();
		//String timeId = getTimeID(times, men.getSlot_ID());
		
		String id = men.getId();
		String name = men.getName();
		String veg = men.getVegetarian() + "";
		String type = men.getType();
		String desc = men.getDescription();
		String time = men.getSlot_ID();
		String pic = men.getPhoto();
		float price = men.getPrice();
		String query = "UPDATE items SET name=?, vegetarian=?, item_type_id=?, description=?, time_slot_id=?, photo=?, price=? WHERE item_id=?";
		jdbcTemplate.update(query, name, veg, type, desc, time, pic, price, id);
		
	}
	
	
	//TODO update with jdbc template
	/*
	public ArrayList<Menu> getByType(String type){
		ArrayList<Menu> menArr = new ArrayList<Menu>();
		ArrayList<TimeSlots> times = timServ.list();
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items WHERE items_type_id = " + type);
			while(rs.next()){
				float price = rs.getFloat("price");
				String tid = rs.getString("time_slot_id");
				String tName = getTimeName(times, tid);
				Menu men = new Menu(rs.getString("item_id"), rs.getString("name"), rs.getString("vegetarian").charAt(0), 
						rs.getString("item_type_id"), rs.getString("description"), tName, 
						rs.getString("photo"), price);
				menArr.add(men);
			}
			return menArr;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	private String getTimeName(ArrayList<TimeSlots> timeArr, String id){
		String tName="";
		for(TimeSlots tim:timeArr){
			if(tim.getSlot_ID().equals(id))
				tName = tim.getTimeName();
		}
		return tName;
	}
	
	private String getTimeID(ArrayList<TimeSlots> timeArr, String name){
		String id="";
		for(TimeSlots tim:timeArr){
			if(tim.getTimeName().equals(name))
				id = tim.getSlot_ID();
		}
		return id;
	}
	*/

}