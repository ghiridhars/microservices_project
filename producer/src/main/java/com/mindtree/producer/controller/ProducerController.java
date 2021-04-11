/**
 * 
 */
package com.mindtree.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mindtree.producer.entity.Producer;
import com.mindtree.producer.feignClients.ItemClient;
import com.mindtree.producer.model.Item;
import com.mindtree.producer.model.Product;
import com.mindtree.producer.repositorydao.ProducerRepo;
import com.mindtree.producer.service.ProducerService;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	/*
	 * 
	 * http://localhost:8930/producer/*
	 * 
	 * To Access from Zuul API Gateway
	 * http://localhost:8989/onlineStore/producerService/producer/*
	 */

	@Autowired
	ProducerService producerService;

	@Autowired
	ItemClient itemFeign;

	@GetMapping("/getProducerBy/{name}")
	public Producer getProducerBy(@PathVariable String name) {
		return producerService.getByName(name);
	}

	@GetMapping("/getItems")
	public Product getItemsBy() {
		return itemFeign.getItems();
	}

	@GetMapping("/getProducer/{id}")
	public Producer getProducerBy(@PathVariable int id) {
		return producerService.getById(id);
	}

	@PostMapping(value = "/addItem")
	public Item addItem(@RequestBody Item it) {
		return itemFeign.addItem(it);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateItem/{name}")
	public Item updateItem(@RequestBody Item id, @PathVariable String name) {
		return itemFeign.updateItem(id, name);
	}

	@DeleteMapping(value = "/deleteItem/{name}")
	public boolean deleteItem(@PathVariable String name) {
		return itemFeign.deleteItem(name);
	}

	@PostMapping("/addProducer")
	public Producer addProducer(@RequestBody Producer p) {
		return producerService.addProducer(p);
	}

//	@GetMapping("/getProducers")
//	public List<Producer> getSkill() throws InterruptedException {
//		return producerService.getAllData();
//	}

//	@GetMapping("/hello")
//	public String sayHello() {
//		producerService.clear();
//		return "Hello Hello";
//	}

//	@DeleteMapping("/deleteProducer/{id}")
//	public boolean delteProducer(@PathVariable int id) {
//		return producerService.deleteById(id);
//	}

//	@PutMapping("/updateProducer/{id}")
//	public Producer updateProducer(@RequestBody Producer p, @PathVariable int id) throws InterruptedException {
//		return producerService.updateProducer(p, id);
//	}

}
