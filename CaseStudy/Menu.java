package CaseStudy;

public class Menu {
	int id;
	String name;
	String vegetarian;
	String description;
	int slot_ID;
	String photo;
	float price;
	
	public Menu(int id, String name, String vegetarian, String description, int slot_ID, String photo, float price) {
		super();
		this.id = id;
		this.name = name;
		this.vegetarian = vegetarian;
		this.description = description;
		this.slot_ID = slot_ID;
		this.photo = photo;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(String vegetarian) {
		this.vegetarian = vegetarian;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSlot_ID() {
		return slot_ID;
	}

	public void setSlot_ID(int slot_ID) {
		this.slot_ID = slot_ID;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
