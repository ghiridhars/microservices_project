package com.mindtree.cart.service;

import org.springframework.stereotype.Service;

import com.mindtree.cart.entity.Cart;
import com.mindtree.cart.exception.CartMicroserviceException;
import com.mindtree.cart.model.Item;

@Service
public interface CartService {

	public Cart getCartData(int id) throws CartMicroserviceException;

	public Cart addItem(Item p,int id);
		
	public boolean deleteCartById(int id);
	
	public boolean deleteItemById(Item p,int id) throws CartMicroserviceException;

	public Cart addCart(int cust_id);

//	public Cart updateItem(Item p, int id);

}
