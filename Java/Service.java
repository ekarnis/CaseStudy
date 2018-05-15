package CaseStudy;

public interface Service<E> {
	public void deleteById(String id);
	public void add(E obj);
	public void update(E obj);
	public Object getById(String id);
	public Object getAll();

}
