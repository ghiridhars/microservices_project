package com.mindtree.Item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Item.entity.Item;

@Service
public interface ItemService {

	List<Item> getAllData();

	Item addItem(Item p);
		
	void clear();

	List<Item> getByType(String prod);

	boolean deleteByName(String name);

	Item updateItem(Item p, String name);

	Item getById(int id);

	Item getItemByName(String name);

	List<Item> getAllItemsById(List<Integer> ids);
}
