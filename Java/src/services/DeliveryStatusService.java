package services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.DeliveryStatus;

public class DeliveryStatusService implements Service<DeliveryStatus>{
	
	Connection connection;
	
	public DeliveryStatusService() {
		super();
	}
	public DeliveryStatusService(Connection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public ArrayList<DeliveryStatus> getAll(){

		ArrayList<DeliveryStatus> deliveryStatuses = new ArrayList<DeliveryStatus>();
		
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM DELIVERY_STATUSES");
			
			while(rs.next()){
				DeliveryStatus deliveryStatus = new DeliveryStatus(rs.getInt(1),rs.getString(2)); 
				deliveryStatuses.add(deliveryStatus);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return deliveryStatuses;
	}

	@Override
	public void deleteById(String id) {
		try{
			
			CallableStatement statement = connection.prepareCall("{call DeleteDeliveryStatus(?)}");
			statement.setString(1, id);
			statement.execute();
			statement.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	@Override
	public boolean add(DeliveryStatus deliveryStatus) {
		try{
			CallableStatement statement = connection.prepareCall("{call AddDeliveryStatus(?, ?)}");
			statement.setInt(1, deliveryStatus.getDelivery_status_id());
			statement.setString(2, deliveryStatus.getDelivery_status());
			statement.execute();
			statement.close();
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}	
	}
	@Override
	public void update(DeliveryStatus deliveryStatus) {
		String statement = "UPDATE DELIVERY_STATUSES SET DELIVERY_STATUS = ?"
				+ "WHERE DELIVERY_STATUS_ID = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(statement);
			
			preparedStatement.setString(1, deliveryStatus.getDelivery_status());
			preparedStatement.setInt(2, deliveryStatus.getDelivery_status_id());
			preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public DeliveryStatus getById(String id) {
		DeliveryStatus deliveryStatus = null;
		
		try{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM DELIVERY_METHODS WHERE DELIVERY_METHOD_ID = " + id);
			
			resultSet.next();
			deliveryStatus = new DeliveryStatus(
					resultSet.getInt(1),
					resultSet.getString(2)
					); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
		
		return deliveryStatus;
	}
	
	
}
