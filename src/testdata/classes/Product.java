package testdata.classes;

import utils.Reader;

public class Product {
	
	private String title;
	private String description;
	private String price;
	private String quantity;


	
	public Product(String filename) {
		this.title = Reader.json(filename).get("title").toString();
		this.description = Reader.json(filename).get("description").toString();
		this.price = Reader.json(filename).get("price").toString();
		this.quantity = Reader.json(filename).get("quantity").toString();

	}


	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
}
