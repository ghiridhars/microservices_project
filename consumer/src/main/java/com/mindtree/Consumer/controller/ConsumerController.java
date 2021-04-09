/**
 * 
 */
package com.mindtree.Consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.Consumer.VO.Producer;
import com.mindtree.Consumer.VO.Product;
import com.mindtree.Consumer.feignClients.ItemClient;
import com.mindtree.Consumer.feignClients.ProducerClient;
import com.mindtree.Consumer.model.Consumer;
import com.mindtree.Consumer.repositorydao.ConsumerRepo;
import com.mindtree.Consumer.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	/*
	 * http://localhost:8931/consumer/*
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

	@GetMapping("/hello")
	public String sayHello() {
		consumerService.clear();
		return "Hello Hello";
	}

	@GetMapping("/getProducerBy/{name}")
	public Producer getProducerByName(@PathVariable String name) {

		Producer p1 = producerClient.getProducerBy(name);

		return p1;
	}

	@GetMapping("/getItemsBy/{name}")
	public Product getItemByProducer(@PathVariable String name) {

		Product p1 = itemClient.getItemBy(name);

		return p1;
	}

	@GetMapping("/getConsumers")
	public List<Consumer> getConsumer() throws InterruptedException {
		return consumerService.getAllData();
	}

	@PostMapping("/addConsumer")
	public Consumer addConsumer(@RequestBody Consumer c) {
		return consumerService.addConsumer(c);
	}

	@DeleteMapping("/deleteConsumer/{id}")
	public boolean delteConsumer(@PathVariable int id) {
		return consumerService.deleteById(id);
	}

	@PatchMapping("/updateConsumer/{id}")
	public Consumer updateConsumer(@RequestBody Consumer p, @PathVariable int id) throws InterruptedException {
		return consumerService.updateConsumer(p, id);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
