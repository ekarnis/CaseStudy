package CaseStudy;

import java.sql.Connection;
import java.util.ArrayList;

public class LocationService {
	Connection con;

	public LocationService() {
		super();
	}

	public LocationService(Connection con) {
		super();
		this.con = con;
	}
	
	public void add(Location location){
		
	}
	public void deleteById(String locationId){
		
	}
	public ArrayList<Location> getAll(){
		ArrayList<Location> locations = new ArrayList<Location>();
		
		return locations;
	}
	public Location getById(String locationId){
		Location location = new Location();
		
		return location;
	}
	
	public void update(Location location){
		
		
	}

}
