package CaseStudy;

import java.sql.Connection;
import java.util.ArrayList;

public class StoreService {
	Connection con;

	public StoreService() {
		super();
	}

	public StoreService(Connection con) {
		super();
		this.con = con;
	}
	
	public void add(Store store){
		
	}
	public void deleteById(String storeId){
		
	}
	public ArrayList<Store> getAll(){
		ArrayList<Store> stores = new ArrayList<Store>();
		
		return stores;
	}
	public Store getById(String StoreId){
		Store store = new Store();
		
		return store;
	}
	
	public void update(Store store){
		
		
	}

}
