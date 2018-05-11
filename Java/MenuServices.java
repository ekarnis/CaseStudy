package CaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuServices {
	public Menu fetchSpecific(int id, Statement stat){
		
		try {
			ResultSet rs = stat.executeQuery("SELECT * FROM items WHERE item_id = " + id);
			rs.next();
			
			float price = rs.getFloat("price");
			Menu men = new Menu(rs.getInt("item_id"), rs.getString("name"), rs.getString("vegetarian").charAt(0), rs.getString("description"), rs.getInt("time_slot_id"), rs.getString("photo"), price);
			return men;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public ArrayList<Menu> fetchAll(Statement stat){
		ArrayList<Menu> menArr = new ArrayList<Menu>();
		try {
			ResultSet rs = stat.executeQuery("SELECT * FROM items");
			while(rs.next()){
				float price = rs.getFloat("price");
				Menu men = new Menu(rs.getInt("item_id"), rs.getString("name"), rs.getString("vegetarian").charAt(0), rs.getString("description"), rs.getInt("time_slot_id"), rs.getString("photo"), price);
				menArr.add(men);
			}
			return menArr;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void add(Menu men, Connection con){
		try{
								
			//con.setAutoCommit(false);
			PreparedStatement preStmt = con.prepareStatement("insert into items values(?,?,?,?,?,?,?)");
			preStmt.setInt(1, men.getId());
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
	
	public void delete(int id, Statement stat){
		try {
			stat.executeQuery("DELETE FROM items WHERE item_id = " + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
