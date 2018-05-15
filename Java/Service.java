package CaseStudy;

public interface Service<E> {
	public void deleteByID(String id);
	public void add(E obj);
	public void update(E obj);
	public Object getByID(String id);
	public Object getAll();

}
