package com.tigers.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tigers.models.Order;

public class OrderService implements Service<Order>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	public OrderService() {
		super();
	}
	
	@Override
	public void add(Order order) {
		try{
			String orderId = getPK();
			String userId = order.getUserId();
			float tip = order.getTip();
			float totalPrice = order.getTotalPrice();
			int placedTimestamp = order.getPlacedTimestamp();
			int deliveryTimestamp = order.getDeliveryTimestamp();
			String cardId = order.getCardId();
			String instructions = order.getInstuctions();
			String deliveryMethodId = order.getDeliveryMethodId();
			String storeId = order.getStoreId();
			String deliveryStatusId = order.getDeliveryStatusId();
			List<String> itemIds = order.getItemIds();
			
			String query = "{CALL AddOrder(?,?,?,?,?,?,?,?,?,?,?)}";
			
			jdbcTemplate.update(query, orderId, userId, tip, totalPrice, placedTimestamp,
								deliveryTimestamp, cardId, instructions, deliveryMethodId, 
								storeId, deliveryStatusId);
			
			// insert corresponding order items
			addOrderItems(orderId, itemIds);
			
			System.out.println("OrderService:  Order added");
		} catch(Exception e) {
			System.out.println("OrderService:  Failed to insert order");
			System.out.println(e.getMessage());
		}	
	}
	
	
	/*
	 * Inserts all order items corresponding to the given order object
	 */
	private void addOrderItems(String orderId, List<String> itemIds) {
		String query = "{CALL AddOrderItem(?,?)}";
		
		for (String itemId: itemIds) {
			jdbcTemplate.update(query, orderId, itemId);
		}
	}
	
	
	/*
	 * Deletes an existing order by order id
	 */
	@Override
	public void delete(String orderId) {
		try{
			// delete all order items first
			deleteOrderItems(orderId);
			
			String query = "{CALL DeleteOrder(?)}";
			
			jdbcTemplate.update(query, orderId);
			System.out.println("OrderService:  Order deleted");
		} catch(Exception e) {
			System.out.println("OrderService:  Failed to delete order");
			System.out.println(e.getMessage());
		}	
	}
	
	
	/*
	 * Deletes all order items corresponding to a given order id 
	 */
	private void deleteOrderItems(String orderId) {
		String query = "{CALL DeleteOrderItems(?)}";
		jdbcTemplate.update(query, orderId);
	}
	
	
	/*
	 * Return list of all existing orders
	 */
	@Override
	public List<Order> list() {
		String query = "SELECT * From Orders";
		List<Order> orders = jdbcTemplate.query(query, new RowMapper<Order>() {
			
			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order order = new Order();
				order.setOrderId(rs.getString("order_id"));
				order.setUserId(rs.getString("user_id"));
				order.setTip(rs.getFloat("tip"));
				order.setTotalPrice(rs.getFloat("total_price"));
				order.setPlacedTimestamp(rs.getInt("placed_timestamp"));
				order.setDeliveryTimestamp(rs.getInt("delivery_timestamp"));
				order.setCardId(rs.getString("card_id"));
				order.setInstuctions(rs.getString("instructions"));
				order.setDeliveryMethodId(rs.getString("delivery_method_id"));
				order.setStoreId(rs.getString("store_id"));
				order.setDeliveryStatusId(rs.getString("delivery_status_id"));
				order.setItemIds(getOrderItems(order.getOrderId()));
				
				return order;
			}
		});
		
		return orders;
	}
	
	
	/*
	 * Return list of all orders corresponding to a given user id
	 */
	public List<Order> list(String userId) {
		String query = "SELECT * FROM Orders WHERE user_id = '" + userId + "'";
		List<Order> orders = jdbcTemplate.query(query, new RowMapper<Order>() {
			
			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order order = new Order();
				order.setOrderId(rs.getString("order_id"));
				order.setUserId(rs.getString("user_id"));
				order.setTip(rs.getFloat("tip"));
				order.setTotalPrice(rs.getFloat("total_price"));
				order.setPlacedTimestamp(rs.getInt("placed_timestamp"));
				order.setDeliveryTimestamp(rs.getInt("delivery_timestamp"));
				order.setCardId(rs.getString("card_id"));
				order.setInstuctions(rs.getString("instructions"));
				order.setDeliveryMethodId(rs.getString("delivery_method_id"));
				order.setStoreId(rs.getString("store_id"));
				order.setDeliveryStatusId(rs.getString("delivery_status_id"));
				order.setItemIds(getOrderItems(order.getOrderId()));
				
				return order;
			}
		});
		
		return orders;
	}
	
	
	/*
	 * Return list of all order items corresponding to given order id
	 */
	private List<String> getOrderItems(String orderId) {
		String query = "SELECT * FROM Order_Items WHERE order_id = '" + orderId +"'";
		List<String> orderItems = jdbcTemplate.query(query, new RowMapper<String>() {
			
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String itemId = rs.getString("item_id");
				return itemId;
			}
		});
		
		return orderItems;
	}
	
	
	/*
	 * Update an existing order with new order values
	 */
	@Override
	public void update(Order order) {
		String orderId = order.getOrderId();
		String userId = order.getUserId();
		float tip = order.getTip();
		float totalPrice = order.getTotalPrice();
		int placedTimestamp = order.getPlacedTimestamp();
		int deliveryTimestamp = order.getDeliveryTimestamp();
		String cardId = order.getCardId();
		String instructions = order.getInstuctions();
		String deliveryMethodId = order.getDeliveryMethodId();
		String storeId = order.getStoreId();
		String deliveryStatusId = order.getDeliveryStatusId();
		List<String> itemIds = order.getItemIds();
			
		String query = "{CALL UpdateOrder(?,?,?,?,?,?,?,?,?,?,?)}";
		
		jdbcTemplate.update(query, orderId, userId, tip, totalPrice,
							placedTimestamp, deliveryTimestamp, cardId,
							instructions, deliveryMethodId, storeId,
							deliveryStatusId, itemIds);
		
		//Remove all old items from Order_Items
		deleteOrderItems(orderId);
			
		//Add new items to Order_Items
		addOrderItems(orderId, itemIds);
	}

	
	/*
	 * Return order object by order id
	 */
	/*
	@Override
	public Order get(String orderId) {
		List<String> itemIds = getOrderItems(orderId);
		String query = "SELECT * FROM ORDERS WHERE order_id = '" + orderId + "'";
		
		
		return order;
	}
	
	
	public ArrayList<Order> getUserOrders(String userId){
		ArrayList<Order> orders = new ArrayList<Order>();
		Order order;
		ArrayList<String> order_items = new ArrayList<String>();
		try{
			//Get Order
			Statement statement = connection.createStatement();
			ResultSet resultSetOrders = statement.executeQuery("SELECT * FROM ORDERS WHERE USER_ID = '" + userId + "'");
			
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
				order = new Order(resultSetOrders.getString("ORDER_ID"),
						resultSetOrders.getString("USER_ID"),
						resultSetOrders.getFloat("TIP"),
						resultSetOrders.getFloat("TOTAL_PRICE"),
						resultSetOrders.getInt("PLACED_TIMESTAMP"),
						resultSetOrders.getInt("DELIVERY_TIMESTAMP"),
						resultSetOrders.getString("CARD_ID"),
						resultSetOrders.getString("INSTRUCTIONS"),
						resultSetOrders.getString("DELIVERY_METHOD_ID"),
						resultSetOrders.getString("STORE_ID"),
						resultSetOrders.getString("DELIVERY_STATUS_ID"),
						order_items);
				orders.add(order);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return orders;
	}
	
	
	public void addItem_id(String item_id, String order_id) { 
		try{
			CallableStatement statement = connection.prepareCall(
					"{call AddOrderItem(?,?)}");
			statement.setString(1, order_id);
			statement.setString(2, item_id);
			statement.execute();
			statement.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	/*
	 * Gets a new, unique orderId based on Unix time in string format
	 */
	
	private String getPK() {
		long unixTime = System.currentTimeMillis() / 1000L;
		return "" + unixTime;
	}

	@Override
	public Order get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
