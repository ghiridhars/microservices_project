package com.mindtree.Item.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String brand;
	private String itemType;
	private float price_per_quantity;

	public Item(int id, String name, String brand, String itemType, float price_per_quantity) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
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

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public float getPrice_per_quantity() {
		return price_per_quantity;
	}

	public void setPrice_per_quantity(float price_per_quantity) {
		this.price_per_quantity = price_per_quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
