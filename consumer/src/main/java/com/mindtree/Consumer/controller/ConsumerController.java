/**
 * 
 */
package com.mindtree.Consumer.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Consumer.entity.Consumer;
import com.mindtree.Consumer.exception.ConsumerMicroserviceException;
import com.mindtree.Consumer.exception.ConsumerServiceException;
import com.mindtree.Consumer.feignClients.CartClient;
import com.mindtree.Consumer.feignClients.ItemClient;
import com.mindtree.Consumer.feignClients.ProducerClient;
import com.mindtree.Consumer.model.Cart;
import com.mindtree.Consumer.model.CartItems;
import com.mindtree.Consumer.model.Item;
import com.mindtree.Consumer.model.Producer;
import com.mindtree.Consumer.model.Product;
import com.mindtree.Consumer.repositorydao.ConsumerRepo;
import com.mindtree.Consumer.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	/*
	 * http://localhost:8939/consumer/*
	 * 
	 * To Access from Zuul API Gateway
	 * http://localhost:8989/onlineStore/consumerService/consumer/getConsumers
	 */
	@Autowired
	ConsumerService consumerService;

	@Autowired
	ProducerClient producerClient;

	@Autowired
	ItemClient itemClient;

	@Autowired
	CartClient cartClient;

	@GetMapping("/getAllItems")
	public List<Item> getItems() {
		return itemClient.getItems();
	}

	@GetMapping("/getItemsBy/{name}")
	public List<Item> getItemByProducer(@PathVariable String name) {
		return itemClient.getItemBy(name);
	}

	@GetMapping("/getConsumers")
	public List<Consumer> getConsumer() throws InterruptedException {
		return consumerService.getAllData();
	}

	@PostMapping("/addConsumer")
	public Consumer addConsumer(@RequestBody Consumer c) {
		Consumer con= consumerService.addConsumer(c);
		cartClient.addCart(con.getId());
		return con;
	}
	
	@GetMapping(value = "/getCart/{id}")
	public ResponseEntity<CartItems> getItemsCart(@PathVariable int id) throws ConsumerMicroserviceException {
		CartItems citems=null;
		try {
			Cart c =cartClient.getItemsCart(id);
			Iterator<Integer> itr = c.getItem_id().iterator();
			List<Item> items = new ArrayList<>();
			while(itr.hasNext()) {
				Item x =itemClient.getItemById(itr.next());
				items.add(x);
			}
			if(items.size() == 0) {
				throw new ConsumerServiceException("No items in the list");
			}
			citems = new CartItems(id,items,c.getTotal());
			return new ResponseEntity<>(citems,HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ConsumerMicroserviceException(e.getMessage(),e);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/addItemToCart/{id}/{c_id}")
	public ResponseEntity<Cart> addItemToCart(@PathVariable int id, @PathVariable int c_id) {
		return new ResponseEntity<>(cartClient.addItemToCart(id, c_id),HttpStatus.ACCEPTED);
	}

	@PutMapping("/deleteItem/{id}/{c_id}")
	public ResponseEntity<Boolean> deleteItem(@PathVariable int id, @PathVariable int c_id) throws ConsumerMicroserviceException {
		try {
			return new ResponseEntity<>(cartClient.deleteItem(id, c_id),HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ConsumerMicroserviceException(e.getMessage(),e);
		}
	}

//	@DeleteMapping("/deleteConsumer/{id}")
//	public boolean delteConsumer(@PathVariable int id) {
//		return consumerService.deleteById(id);
//	}
//
//	@PatchMapping("/updateConsumer/{id}")
//	public Consumer updateConsumer(@RequestBody Consumer p, @PathVariable int id) throws InterruptedException {
//		return consumerService.updateConsumer(p, id);
//	}

//	@GetMapping("/hello")
//	public String sayHello() {
//		consumerService.clear();
//		return "Hello Hello";
//	}

//	@GetMapping("/getItemsBy/{name}")
//	public Producer getProducerByName(@PathVariable String name) {
//		Producer p1 = producerClient.getProducerBy(name);
//		return p1;
//	}

}
