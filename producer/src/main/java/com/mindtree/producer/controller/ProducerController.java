/**
 * 
 */
package com.mindtree.producer.controller;

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

import com.mindtree.producer.entity.Producer;
import com.mindtree.producer.exception.ProducerMicroserviceException;
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
	public ResponseEntity<Producer> getProducerBy(@PathVariable String name) {
		return new ResponseEntity<>(producerService.getByName(name), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getItems")
	public ResponseEntity<Product> getItemsBy() throws ProducerMicroserviceException {
		try {
			return new ResponseEntity<>(itemFeign.getItems(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ProducerMicroserviceException(e.getMessage(), e);
		}
	}
	
	@GetMapping("/getItemByBrand/{brand}")
	public ResponseEntity<List<Item>> getItemsByBrand(@PathVariable String brand) throws ProducerMicroserviceException {
		try {
			return new ResponseEntity<>(itemFeign.getItemsByBrand(brand),HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ProducerMicroserviceException(e.getMessage(), e);
		}
	}

	@GetMapping("/getProducer/{id}")
	public ResponseEntity<Producer> getProducerBy(@PathVariable int id) {
		return new ResponseEntity<>(producerService.getById(id), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/addItem")
	public ResponseEntity<Item> addItem(@RequestBody Item it) throws ProducerMicroserviceException {
		try {
			return new ResponseEntity<>(itemFeign.addItem(it), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ProducerMicroserviceException(e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateItem/{name}")
	public ResponseEntity<Item> updateItem(@RequestBody Item id, @PathVariable String name) throws ProducerMicroserviceException {
		try {
			return new ResponseEntity<>(itemFeign.updateItem(id, name), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ProducerMicroserviceException(e.getMessage(), e);
		}
	}

	@DeleteMapping(value = "/deleteItem/{name}")
	public ResponseEntity<Boolean> deleteItem(@PathVariable String name) throws ProducerMicroserviceException {
		try {
			return new ResponseEntity<>(itemFeign.deleteItem(name), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ProducerMicroserviceException(e.getMessage(), e);
		}
	}

	@PostMapping("/addProducer")
	public ResponseEntity<Producer> addProducer(@RequestBody Producer p) {
		return new ResponseEntity<>(producerService.addProducer(p), HttpStatus.ACCEPTED);
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
