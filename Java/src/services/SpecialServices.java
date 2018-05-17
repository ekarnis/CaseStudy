package services;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;


public class SpecialServices implements ServiceOperations<Special> {
	Connection con;
	
	public SpecialServices(Connection con) {
		super();
		this.con = con;
	}

	public void add(Special spec){
		CallableStatement oracleCallStmt;
		try {
			oracleCallStmt = con.prepareCall("{call insertSpecial(?,?)}");
			oracleCallStmt.setString(1, spec.getItem_ID());
			oracleCallStmt.setInt(2, spec.getDiscoutPercentage());
			oracleCallStmt.execute();
			System.out.println("Successful?");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteById(String id){
		CallableStatement stmt;
		try {
			stmt = con.prepareCall("{call deleteSpecial(?)}");
			stmt.setString(1, id);
			System.out.println("Deleted?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Special getByID(String id){
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM specials WHERE item_id = " + id);
			rs.next();
			
			Special spec = new Special(rs.getString("item_id"), rs.getInt("discount_percentatge"));
			return spec;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Special> getAll(){
		ArrayList<Special> specArr = new ArrayList<Special>();
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items");
			while(rs.next()){
				Special spec = new Special(rs.getString("item_id"), rs.getInt("discount_percentage"));
				specArr.add(spec);
			}
			return specArr;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void update(Special spec){
		
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		
	}
}
