package caseStudy;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
	
	int order_id;
	int user_id;
	Date placed_timestamp;
	Date delivery_timestamp;
	int card_id;
	String instuctions;
	int delivery_method_id;
	int store_id;
	int delivery_status_id;
	
	//Array to hold order items rather than the order_items table
	ArrayList<Integer> item_ids = new ArrayList<Integer>();

	public Order(int order_id, int user_id, Date placed_timestamp, Date delivery_timestamp, int card_id,
			String instuctions, int delivery_method_id, int store_id, int delivery_status_id,
			ArrayList<Integer> item_ids) {
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

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", placed_timestamp=" + placed_timestamp
				+ ", delivery_timestamp=" + delivery_timestamp + ", card_id=" + card_id + ", instuctions=" + instuctions
				+ ", delivery_method_id=" + delivery_method_id + ", store_id=" + store_id + ", delivery_status_id="
				+ delivery_status_id + ", item_ids=" + item_ids + "]";
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getPlaced_timestamp() {
		return placed_timestamp;
	}

	public void setPlaced_timestamp(Date placed_timestamp) {
		this.placed_timestamp = placed_timestamp;
	}

	public Date getDelivery_timestamp() {
		return delivery_timestamp;
	}

	public void setDelivery_timestamp(Date delivery_timestamp) {
		this.delivery_timestamp = delivery_timestamp;
	}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	public String getInstuctions() {
		return instuctions;
	}

	public void setInstuctions(String instuctions) {
		this.instuctions = instuctions;
	}

	public int getDelivery_method_id() {
		return delivery_method_id;
	}

	public void setDelivery_method_id(int delivery_method_id) {
		this.delivery_method_id = delivery_method_id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public int getDelivery_status_id() {
		return delivery_status_id;
	}

	public void setDelivery_status_id(int delivery_status_id) {
		this.delivery_status_id = delivery_status_id;
	}

	public ArrayList<Integer> getItem_ids() {
		return item_ids;
	}

	public void setItem_ids(ArrayList<Integer> item_ids) {
		this.item_ids = item_ids;
	}
	
	
	
}
