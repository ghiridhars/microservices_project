package com.mindtree.Item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Item.entity.Item;

@Service
public interface ItemService {

	List<Item> getAllData() throws InterruptedException;

	Item addItem(Item p);
		
	void clear();

	List<Item> getByType(String prod);

	boolean deleteById(int id);

	Item updateItem(Item p, int id);

}
