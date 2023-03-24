package com.spboot.market.dto;

public class ProductDTO {

	private int id;
	private String name;
	private double price;
	private String description;
	// @ElementCollection
	// private List<String> specs;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}

	// public List<String> getSpecs() {
	// return specs;
	// }
	//
	// public void setSpecs(List<String> specs) {
	// this.specs = specs;
	// }

}
