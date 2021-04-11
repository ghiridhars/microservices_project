package com.mindtree.Consumer.model;

public class Item {

	private int id;
	private String name;
	private String itemType;
	private float price_per_quantity;

	public Item(int id, String name, String itemType, float price_per_quantity) {
		super();
		this.id = id;
		this.name = name;
		this.itemType = itemType;
		this.price_per_quantity = price_per_quantity;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice_per_quantity() {
		return price_per_quantity;
	}

	public void setPrice_per_quantity(float price_per_quantity) {
		this.price_per_quantity = price_per_quantity;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
