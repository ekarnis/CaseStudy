package com.tigers.models;

import java.util.ArrayList;
import java.util.List;

import com.tigers.services.MenuServices;

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
	
	public void add(String id) {
		MenuServices menServ = new MenuServices();
		Menu item = menServ.get(id);
		
		totalPrice += item.getPrice();
		
		if(items.contains(item)) {
			//increase the quantity if that item that is already in the cart
			int index = items.indexOf(item);
			int count = quantity.get(index) + 1;
			quantity.set(index, count);
		}
		else {
			items.add(item);
			quantity.add(1);
		}
	}

	public ArrayList<Menu> getItems() {
		return items;
	}

	public ArrayList<Integer> getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
