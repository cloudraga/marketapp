package com.spboot.market.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;
	private String name;
	private String ownerName;
	private String location;
	@OneToOne
	private Product product;

	public int getId() {
		return shopId;
	}

	public void setId(int shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Shop [id=" + shopId + ", name=" + name + ", ownerName=" + ownerName + ", location=" + location
				+ ", product=" + product + "]";
	}

}
