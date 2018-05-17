package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuServices implements ServiceOperations<Menu> {
	Connection con;
	
	public MenuServices(Connection con) {
		super();
		this.con = con;
	}

	public Menu getByID(String id){
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items WHERE item_id = " + id);
			rs.next();
			
			float price = rs.getFloat("price");
			Menu men = new Menu(rs.getString("item_id"), rs.getString("name"), rs.getString("vegetarian").charAt(0), rs.getString("description"), rs.getInt("time_slot_id"), rs.getString("photo"), price);
			return men;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public ArrayList<Menu> getAll(){
		ArrayList<Menu> menArr = new ArrayList<Menu>();
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items");
			while(rs.next()){
				float price = rs.getFloat("price");
				Menu men = new Menu(rs.getString("item_id"), rs.getString("name"), rs.getString("vegetarian").charAt(0), rs.getString("description"), rs.getInt("time_slot_id"), rs.getString("photo"), price);
				menArr.add(men);
			}
			return menArr;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void add(Menu men){
		DatabaseConnection db = new DatabaseConnection();
		
		try{
								
			//con.setAutoCommit(false);
			PreparedStatement preStmt = db.getConnection().prepareStatement("insert into items values(?,?,?,?,?,?,?)");
			preStmt.setString(1, men.getId());
			preStmt.setString(2, men.getName());
			preStmt.setString(3, ("" + men.getVegetarian()));
			preStmt.setString(4, men.getDescription());
			preStmt.setInt(5, men.getSlot_ID());
			preStmt.setString(6, men.getPhoto());
			preStmt.setFloat(7, men.getPrice());
			preStmt.executeUpdate(); //Data is not yet committed
			System.out.println("Inserted");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteByID(int id){
		DatabaseConnection db = new DatabaseConnection();
		try {
			db.getStatement().executeQuery("DELETE FROM items WHERE item_id = " + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Menu men){
		
	}




}
