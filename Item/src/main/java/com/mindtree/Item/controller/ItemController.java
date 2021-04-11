/**
 * 
 */
package com.mindtree.Item.controller;

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

import com.mindtree.Item.entity.Item;
import com.mindtree.Item.model.Product;
import com.mindtree.Item.repositorydao.ItemRepo;
import com.mindtree.Item.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	/*
	 * http://localhost:8932/item/*
	 * 
	 * 
	 * To Access from Zuul API Gateway
	 * http://localhost:8989/onlineStore/itemService/item/*
	 */
	@Autowired
	ItemService itemService;

	@GetMapping("/getItemById/{id}")
	public Item getItemById(@PathVariable int id) {
		return itemService.getById(id);
	}

	@GetMapping("/getItems/{prod}")
	public List<Item> getItemsByProd(@PathVariable String prod) {
		return itemService.getByType(prod);
	}
	
	@GetMapping("/getItemByName/{name}")
	public Item getItemsByName(@PathVariable String name) {
		return itemService.getItemByName(name);
	}
	
	@GetMapping("/getAllItems")
	public List<Item> getAllItems() {
		return itemService.getAllData();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addItem")
	public Item addItem(@RequestBody Item c) {
		return itemService.addItem(c);
	}

	@DeleteMapping("/deleteItem/{name}")
	public boolean delteProducer(@PathVariable String name) {
		return itemService.deleteByName(name);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateItem/{name}")
	public Item updateItem(@RequestBody Item p, @PathVariable String name) throws InterruptedException {
		return itemService.updateItem(p, name);
	}

//	@GetMapping("/hello")
//	public String sayHello() {
//		itemService.clear();
//		return "Hello Hello";
//	}

}
