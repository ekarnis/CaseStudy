package CaseStudy;

import java.util.ArrayList;

public interface Service {
	
	public void add();
	
	public void deleteById(String id);
	
	public ArrayList<Object> getAll();
	
	public Object getById(String id);
	
	public void update(Object o);

}
