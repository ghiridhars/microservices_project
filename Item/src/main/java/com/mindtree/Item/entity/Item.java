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
	private String itemType;
	private float price_per_quantity;
	private short quantity;

	public Item(int id, String name, String itemType, float price_per_quantity, short quantity) {
		super();
		this.id = id;
		this.name = name;
		this.itemType = itemType;
		this.price_per_quantity = price_per_quantity;
		this.quantity = quantity;
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

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

}
