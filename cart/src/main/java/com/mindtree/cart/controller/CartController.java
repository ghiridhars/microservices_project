/**
 * 
 */
package com.mindtree.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.cart.entity.Cart;
import com.mindtree.cart.feignClients.ItemClient;
import com.mindtree.cart.model.Item;
import com.mindtree.cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	/*
	 * http://localhost:8934/cart/*
	 * 
	 * 
	 * To Access from Zuul API Gateway
	 * http://localhost:8989/onlineStore/cartService/cart/*
	 */
	@Autowired
	CartService cartService;
	
	@Autowired
	ItemClient itemClient;

	//getting cartdetails of a particular customer
	@GetMapping("/getCart/{id}")
	public Cart getItemsBy(@PathVariable int id) {
		return cartService.getCartData(id);
	}
	
//	//automatically creating cart when consumer wants to add items
//	@PostMapping("/addCart/{cust_id}")
//	public Cart addCart(@PathVariable int cust_id) {
//		return cartService.addCart(cust_id);
//	}

	//adding items one by one to the cart
	@PutMapping("/addItemToCart/{id}/{c_id}")
	public Cart addItem(@PathVariable int id,@PathVariable int c_id) {
		Item i = itemClient.getItemById(id);
		return cartService.addItem(i,c_id);
	}

	//deleting items one by one from the cart
	@PutMapping("/deleteItem/{id}/{c_id}")
	public boolean deleteItem(@PathVariable int id,@PathVariable int c_id) {
		Item i = itemClient.getItemById(id);
		return cartService.deleteItemById(i,c_id);
	}

//	@PutMapping("/updateProducer/{id}")
//	public Item updateProducer(@RequestBody Item p, @PathVariable int id) throws InterruptedException {
//		return cartService.updateItem(p, id);
//	}

//	@GetMapping("/hello")
//	public String sayHello() {
//		itemService.clear();
//		return "Hello Hello";
//	}

//	@GetMapping("/getItems")
//	public List<Item> getSkill() throws InterruptedException {
//		return itemService.getAllData();
//	}

	
}
