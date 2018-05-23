package services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Order;

public class OrderService implements Service<Order>{
	/*
	ArrayList<Integer> item_ids = new ArrayList<Integer>();
	*/
	
	Connection connection;
	
	public OrderService() {
		super();
	}

	public OrderService(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public boolean add(Order order){
		try{
			//Add order items
			CallableStatement statement = connection.prepareCall(
					"{call AddOrder(?,?,?,?,?,?,?,?,?)}");
			
			statement.setString(1,order.getOrder_id());
			statement.setString(2,order.getUser_id());
			statement.setInt(3,order.getPlaced_timestamp());
			statement.setInt(4,order.getDelivery_timestamp());
			statement.setString(5,order.getCard_id());
			statement.setString(6,order.getInstuctions());
			statement.setString(7,order.getDelivery_method_id());
			statement.setString(8,order.getStore_id());
			statement.setString(9,order.getDelivery_status_id());
			statement.execute();
			statement.close();
			
			//Add all items in order to order_items
			ArrayList<String> item_ids = order.getItem_ids();
			for (String item_id: item_ids){
				statement = connection.prepareCall(
						"{call AddOrderItem(?,?)}");
				statement.setString(1, order.getOrder_id());
				statement.setString(2, item_id);
				statement.execute();
				statement.close();
			}
			return true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return false;
		}	
	}
	
	@Override
	public void deleteById(String id){
		try{
			//Delete order_items
			CallableStatement statement = connection.prepareCall(
					"{call DeleteOrderItems(?)}");
			statement.setString(1,id);
			statement.execute();
			statement.close();
			
			//Delete order 
			statement = connection.prepareCall(
					"{call DeleteOrder(?)}");
			
			statement.setString(1,id);
			statement.execute();
			statement.close();
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}	
	}
	
	@Override
	public ArrayList<Order> getAll(){
		ArrayList<Order> orders = new ArrayList<Order>();
		Order order;
		ArrayList<String> order_items = new ArrayList<String>();
		try{
			//Get Order
			Statement statement = connection.createStatement();
			ResultSet resultSetOrders = statement.executeQuery("SELECT * FROM ORDERS");
			
			ResultSet resultSetItems;
			while(resultSetOrders.next()){
				//fetch all order items
				statement = connection.createStatement();
				resultSetItems = statement.executeQuery(
						"SELECT * FROM ORDER_ITEMS WHERE ORDER_ID = " + resultSetOrders.getString("ORDER_ID"));
				order_items.clear();
				while(resultSetItems.next()){
					order_items.add(resultSetItems.getString("ITEM_ID"));
				}
				
				//Make new order
				order = new Order(resultSetOrders.getString(1),
						resultSetOrders.getString(2),
						resultSetOrders.getInt(3),
						resultSetOrders.getInt(4),
						resultSetOrders.getString(5),
						resultSetOrders.getString(6),
						resultSetOrders.getString(7),
						resultSetOrders.getString(8),
						resultSetOrders.getString(9),
						order_items);
				orders.add(order);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return orders;
	}
	
	public Order getById(String id){
		Order order = new Order();
				try{
					//Get Order
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(
							"SELECT * FROM ORDERS WHERE ORDER_ID = " + id);
					resultSet.next();
					order.setOrder_id(resultSet.getString(1));
					order.setUser_id(resultSet.getString(2));
					order.setPlaced_timestamp(resultSet.getInt(3));
					order.setDelivery_timestamp(resultSet.getInt(4));
					order.setCard_id(resultSet.getString(5));
					order.setInstuctions(resultSet.getString(6));
					order.setDelivery_method_id(resultSet.getString(7));
					order.setStore_id(resultSet.getString(8));
					order.setDelivery_status_id(resultSet.getString(9));


					//get order items
					statement = connection.createStatement();
					resultSet = statement.executeQuery(
							"SELECT * FROM ORDER_ITEMS WHERE ORDER_ID = " + id);
					
					ArrayList<String> order_items = new ArrayList<String>();
					while(resultSet.next()){
						order_items.add(resultSet.getString("ITEM_ID"));
					}
					order.setItem_ids(order_items);	
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}	
				
				return order;
	}
	
	public void update(Order order){
		
	}
}
