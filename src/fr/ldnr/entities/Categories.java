package fr.ldnr.entities;

public class Categories {

	private int Id;
	private String catName;
	private String description;

	public Categories(String catName, String description) {
		super();
		this.catName = catName;
		this.description = description;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
