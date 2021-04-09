package com.mindtree.producer.model;

import java.util.List;

public class Product {

	private String brandName;
	private List<Item> items;

	public Product(String brandName, List<Item> items) {
		super();
		this.brandName = brandName;
		this.items = items;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
