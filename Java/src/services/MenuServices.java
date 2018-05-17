package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuServices implements Service<Menu> {
	Connection con;
	
	public MenuServices(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Menu getById(String id){
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items WHERE item_id = " + id);
			rs.next();
			
			float price = rs.getFloat("price");
			Menu men = new Menu(rs.getString("item_id"), rs.getString("name"), rs.getString("vegetarian").charAt(0), rs.getString("item_type_id"), rs.getString("description"), rs.getInt("time_slot_id"), rs.getString("photo"), price);
			return men;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public ArrayList<Menu> getAll(){
		ArrayList<Menu> menArr = new ArrayList<Menu>();
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items");
			while(rs.next()){
				float price = rs.getFloat("price");
				Menu men = new Menu(rs.getString("item_id"), rs.getString("name"), rs.getString("vegetarian").charAt(0), rs.getString("item_type_id"), rs.getString("description"), rs.getInt("time_slot_id"), rs.getString("photo"), price);
				menArr.add(men);
			}
			return menArr;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public boolean add(Menu men){		
		try{
								
			//con.setAutoCommit(false);
			PreparedStatement preStmt = con.prepareStatement("insert into items values(?,?,?,?,?,?,?,?)");
			preStmt.setString(1, men.getId());
			preStmt.setString(2, men.getName());
			preStmt.setString(3, ("" + men.getVegetarian()));
			preStmt.setString(3, men.getType());
			preStmt.setString(4, men.getDescription());
			preStmt.setInt(5, men.getSlot_ID());
			preStmt.setString(6, men.getPhoto());
			preStmt.setFloat(7, men.getPrice());
			preStmt.executeUpdate(); //Data is not yet committed
			System.out.println("Inserted");
			return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void deleteById(String id){
		try {
			con.createStatement().executeQuery("DELETE FROM items WHERE item_id = " + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Menu men){
		
	}
	
	public ArrayList<Menu> getByType(String type){
		ArrayList<Menu> menArr = new ArrayList<Menu>();
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items WHERE item_type_id=" + type);
			while(rs.next()){
				float price = rs.getFloat("price");
				Menu men = new Menu(rs.getString("item_id"), rs.getString("name"), rs.getString("vegetarian").charAt(0), rs.getString("item_type_id"), rs.getString("description"), rs.getInt("time_slot_id"), rs.getString("photo"), price);
				menArr.add(men);
			}
			return menArr;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}




}