package com.mindtree.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cust_id;
	private List<Item> item;
	private float total;

	public Cart(int id, int cust_id, int[] item_id, float total) {
		super();
		this.id = id;
		this.cust_id = cust_id;
		this.item_id = item_id;
		this.total = total;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getItem_id() {
		return item_id;
	}

	public void setItem_id(int[] item_id) {
		this.item_id = item_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

}
