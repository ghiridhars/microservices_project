package com.mindtree.Consumer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Producer {

	private int id;
	private String name;
	private String brandName;

	public Producer(int id, String name, String brandName, String productType) {
		super();
		this.id = id;
		this.name = name;
		this.brandName = brandName;
	}

	public Producer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

}
