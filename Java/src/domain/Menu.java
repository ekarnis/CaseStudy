package domain;

public class Menu {
	String id;
	String name;
	char vegetarian;
	String description;
	String type;
	int slot_ID;
	String photo;
	float price;
	
	public Menu(String id, String name, char vegetarian, String type, String description, int slot_ID, String photo, float price) {
		super();
		this.id = id;
		this.name = name;
		this.vegetarian = vegetarian;
		this.type = type;
		this.description = description;
		this.slot_ID = slot_ID;
		this.photo = photo;
		this.price = price;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(char vegetarian) {
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


	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", vegetarian=" + vegetarian + ", description=" + description
				+ ", type=" + type + ", slot_ID=" + slot_ID + ", photo=" + photo + ", price=" + price + "]";
	}

	
}
