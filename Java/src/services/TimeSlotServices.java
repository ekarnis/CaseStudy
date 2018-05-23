package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TimeSlotServices implements Service<TimeSlot>	{

	Connection con;
	
	public TimeSlotServices(Connection con) {
		super();
		this.con = con;
	}
	
	@Override
	public void deleteById(String id) {
		try {
			con.createStatement().executeQuery("DELETE FROM item_slot_id WHERE time_slot_id = " + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean add(TimeSlot tim) {
		try{
			
			//con.setAutoCommit(false);
			PreparedStatement preStmt = con.prepareStatement("insert into time_slots values(?,?,?,?)");
			preStmt.setString(1, tim.getSlot_ID());
			preStmt.setInt(2, tim.getTimeStart());
			preStmt.setInt(3, tim.getTimeEnd());
			preStmt.setString(4, tim.getTimeName());
			preStmt.executeUpdate(); //Data is not yet committed
			return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void update(TimeSlot obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TimeSlot getById(String id) {
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM time_slots WHERE time_slot_id = " + id);
			rs.next();
			
			TimeSlot tim = new TimeSlot(rs.getString("time_slot_id"), rs.getInt("slot_start"), rs.getInt("slot_end"), rs.getString("slot_name"));
			return tim;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<TimeSlot> getAll() {
		ArrayList<TimeSlot> timArr = new ArrayList<TimeSlot>();
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM time_slots");
			while(rs.next()){
				TimeSlot tim = new TimeSlot(rs.getString("time_slot_id"), rs.getInt("slot_start"), rs.getInt("slot_end"), rs.getString("slot_name"));
				timArr.add(tim);
			}
			return timArr;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
