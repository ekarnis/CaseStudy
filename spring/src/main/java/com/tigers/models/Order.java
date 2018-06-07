package com.tigers.models;

import java.util.List;

public class Order {
	
	private String orderId;
	private String userId;
	private float tip;
	private float totalPrice;
	private int placedTimestamp;
	private int deliveryTimestamp;
	private String cardId;
	private String instuctions;
	private String deliveryMethodId;
	private String storeId;
	private String deliveryStatusId;
	private List<String> itemIds;

	public Order() {
		super();
	}

	public Order(String orderId, String userId, float tip, float totalPrice, int placedTimestamp, int deliveryTimestamp,
			String cardId, String instuctions, String deliveryMethodId, String storeId, String deliveryStatusId,
			List<String> itemIds) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.tip = tip;
		this.totalPrice = totalPrice;
		this.placedTimestamp = placedTimestamp;
		this.deliveryTimestamp = deliveryTimestamp;
		this.cardId = cardId;
		this.instuctions = instuctions;
		this.deliveryMethodId = deliveryMethodId;
		this.storeId = storeId;
		this.deliveryStatusId = deliveryStatusId;
		this.itemIds = itemIds;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public float getTip() {
		return tip;
	}

	public void setTip(float tip) {
		this.tip = tip;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPlacedTimestamp() {
		return placedTimestamp;
	}

	public void setPlacedTimestamp(int placedTimestamp) {
		this.placedTimestamp = placedTimestamp;
	}

	public int getDeliveryTimestamp() {
		return deliveryTimestamp;
	}

	public void setDeliveryTimestamp(int deliveryTimestamp) {
		this.deliveryTimestamp = deliveryTimestamp;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getInstuctions() {
		return instuctions;
	}

	public void setInstuctions(String instuctions) {
		this.instuctions = instuctions;
	}

	public String getDeliveryMethodId() {
		return deliveryMethodId;
	}

	public void setDeliveryMethodId(String deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getDeliveryStatusId() {
		return deliveryStatusId;
	}

	public void setDeliveryStatusId(String deliveryStatusId) {
		this.deliveryStatusId = deliveryStatusId;
	}

	public List<String> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", tip=" + tip + ", totalPrice=" + totalPrice
				+ ", placedTimestamp=" + placedTimestamp + ", deliveryTimestamp=" + deliveryTimestamp + ", cardId="
				+ cardId + ", instuctions=" + instuctions + ", deliveryMethodId=" + deliveryMethodId + ", storeId="
				+ storeId + ", deliveryStatusId=" + deliveryStatusId + ", itemIds=" + itemIds + "]";
	}
}
