/**
 * 
 */
package com.mindtree.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
	/*
	 * http://localhost:8932/item/*
	 * 
	 * 
	 * To Access from Zuul API Gateway
	 * http://localhost:8989/onlineStore/itemService/item/*
	 */
	@Autowired
	CartService cartService;

//	@GetMapping("/hello")
//	public String sayHello() {
//		itemService.clear();
//		return "Hello Hello";
//	}

	@GetMapping("/getItems/{prod}")
	public Product getItemsByProd(@PathVariable String prod) {
		Product p = new Product(prod, itemService.getByType(prod));
		return p;
	}

	@GetMapping("/getItems")
	public List<Item> getSkill() throws InterruptedException {
		return itemService.getAllData();
	}

	@PostMapping("/addItem")
	public Item addConsumer(@RequestBody Item c) {
		return itemService.addItem(c);
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public boolean delteProducer(@PathVariable int id) {
		return itemService.deleteById(id);
	}

	@PutMapping("/updateProducer/{id}")
	public Item updateProducer(@RequestBody Item p, @PathVariable int id) throws InterruptedException {
		return itemService.updateItem(p, id);
	}

	
}
