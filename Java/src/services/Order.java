package services;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
	
	String order_id;
	String user_id;
	int placed_timestamp;
	int delivery_timestamp;
	String card_id;
	String instuctions;
	String delivery_method_id;
	String store_id;
	String delivery_status_id;
	
	//Array to hold order items rather than the order_items table
	ArrayList<String> item_ids = new ArrayList<String>();

	public Order(String order_id, String user_id, int placed_timestamp, int delivery_timestamp, String card_id,
			String instuctions, String delivery_method_id, String store_id, String delivery_status_id,
			ArrayList<String> item_ids) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.placed_timestamp = placed_timestamp;
		this.delivery_timestamp = delivery_timestamp;
		this.card_id = card_id;
		this.instuctions = instuctions;
		this.delivery_method_id = delivery_method_id;
		this.store_id = store_id;
		this.delivery_status_id = delivery_status_id;
		this.item_ids = item_ids;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", placed_timestamp=" + placed_timestamp
				+ ", delivery_timestamp=" + delivery_timestamp + ", card_id=" + card_id + ", instuctions=" + instuctions
				+ ", delivery_method_id=" + delivery_method_id + ", store_id=" + store_id + ", delivery_status_id="
				+ delivery_status_id + ", item_ids=" + item_ids + "]";
	}

	public ArrayList<String> getItem_ids() {
		return item_ids;
	}

	public void setItem_ids(ArrayList<String> item_ids) {
		this.item_ids = (ArrayList<String>) item_ids.clone();
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPlaced_timestamp() {
		return placed_timestamp;
	}

	public void setPlaced_timestamp(int placed_timestamp) {
		this.placed_timestamp = placed_timestamp;
	}

	public int getDelivery_timestamp() {
		return delivery_timestamp;
	}

	public void setDelivery_timestamp(int delivery_timestamp) {
		this.delivery_timestamp = delivery_timestamp;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getInstuctions() {
		return instuctions;
	}

	public void setInstuctions(String instuctions) {
		this.instuctions = instuctions;
	}

	public String getDelivery_method_id() {
		return delivery_method_id;
	}

	public void setDelivery_method_id(String delivery_method_id) {
		this.delivery_method_id = delivery_method_id;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getDelivery_status_id() {
		return delivery_status_id;
	}

	public void setDelivery_status_id(String delivery_status_id) {
		this.delivery_status_id = delivery_status_id;
	}
}