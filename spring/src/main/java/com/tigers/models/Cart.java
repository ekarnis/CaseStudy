package com.tigers.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	ArrayList<Menu> items;
	ArrayList<Integer> quantity;
	float totalPrice;
	
	public Cart() {
		totalPrice = 0;
		items = new ArrayList<Menu>();
		quantity = new ArrayList<Integer>();
	}
	
	public float getTotalPrice() {
		return totalPrice;
	}
	
	public void add(Menu item) {
		if(items.contains(item)) {
			//increase the quantity of that item that is already in the cart
			int index = items.indexOf(item);
			int count = quantity.get(index) + 1;
			quantity.set(index, count);
		}
		else {
			items.add(item);
			quantity.add(1);
		}
	}
	
}
