/**
 * 
 */
package com.mindtree.Item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.mindtree.Item.exception.ItemMicroserviceException;
import com.mindtree.Item.exception.ItemServiceException;
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
	public ResponseEntity<Item> getItemById(@PathVariable int id) throws ItemMicroserviceException {
		try {
			return new ResponseEntity<>(itemService.getById(id),HttpStatus.ACCEPTED);
		} catch (ItemServiceException e) {
			throw new ItemMicroserviceException(e.getMessage(), e);
		}
	}

	@GetMapping("/getItems/{prod}")
	public ResponseEntity<List<Item>> getItemsByProd(@PathVariable String prod) throws ItemMicroserviceException {
		try {
			return new ResponseEntity<>(itemService.getByType(prod),HttpStatus.ACCEPTED);
		} catch (ItemServiceException e) {
			throw new ItemMicroserviceException(e.getMessage(), e);
		}
	}

	@GetMapping("/getItemByName/{name}")
	public ResponseEntity<Item> getItemsByName(@PathVariable String name) throws ItemMicroserviceException {
		try {
			return new ResponseEntity<>(itemService.getItemByName(name),HttpStatus.ACCEPTED);
		} catch (ItemServiceException e) {
			throw new ItemMicroserviceException(e.getMessage(), e);
		}
	}

	@GetMapping("/getAllItems")
	public ResponseEntity<List<Item>> getAllItems() {
		return new ResponseEntity<>(itemService.getAllData(),HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addItem")
	public ResponseEntity<Item> addItem(@RequestBody Item c) {
		return new ResponseEntity<>(itemService.addItem(c),HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteItem/{name}")
	public ResponseEntity<Boolean> delteProducer(@PathVariable String name)throws ItemMicroserviceException  {
		try {
			return new ResponseEntity<>(itemService.deleteByName(name),HttpStatus.ACCEPTED);
		} catch (ItemServiceException e) {
			throw new ItemMicroserviceException(e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateItem/{name}")
	public ResponseEntity<Item> updateItem(@RequestBody Item p, @PathVariable String name) throws ItemMicroserviceException {
		try {
			return new ResponseEntity<>(itemService.updateItem(p, name),HttpStatus.ACCEPTED);
		} catch (ItemServiceException e) {
			throw new ItemMicroserviceException(e.getMessage(), e);
		}
	}

//	@GetMapping("/hello")
//	public String sayHello() {
//		itemService.clear();
//		return "Hello Hello";
//	}

}
