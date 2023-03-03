package fr.ldnr.entities;

public class Article {

	private int Id;
	private String description;
	private String brand;
	private double price;

	public Article(int id, String description, String brand, double price) {
		super();
		Id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	public Article(String description, String brand, double price) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	public Article(	int id) {
		super();
		Id = id;
	}

	@Override
	public String toString() {
		return "Article [Id=" + Id + ", description=" + description + ", brand=" + brand + ", price=" + price + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
