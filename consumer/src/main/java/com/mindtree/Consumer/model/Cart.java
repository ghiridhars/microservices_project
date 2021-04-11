package com.mindtree.Consumer.model;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cart {

	private int id;
	private List<Integer> item_id;

	private float total;

	public Cart(int id, List<Integer> item_id, float total) {
		super();
		this.id = id;
		this.setItem_id(item_id);
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<Integer> getItem_id() {
		return item_id;
	}

	public void setItem_id(List<Integer> item_id) {
		this.item_id = item_id;
	}

}
