package com.mindtree.Item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Item.entity.Item;
import com.mindtree.Item.exception.ItemServiceException;

@Service
public interface ItemService {

	List<Item> getAllData();

	Item addItem(Item p);
		
	void clear();

	List<Item> getByType(String prod) throws ItemServiceException;

	boolean deleteByName(String name) throws ItemServiceException;

	Item updateItem(Item p, String name) throws ItemServiceException;

	Item getById(int id) throws ItemServiceException;

	Item getItemByName(String name) throws ItemServiceException;

	List<Item> getAllItemsById(List<Integer> ids);
}
