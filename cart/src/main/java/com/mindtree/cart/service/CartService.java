package com.mindtree.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.cart.entity.Cart;

@Service
public interface ItemService {

	List<Cart> getAllData() throws InterruptedException;

	Cart addItem(Item p);
		
	void clear();

	boolean deleteById(int id);

//	Item updateItem(Item p, int id);

}
