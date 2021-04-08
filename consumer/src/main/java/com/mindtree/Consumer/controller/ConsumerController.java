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
import com.mindtree.Consumer.feignClients.ProducerClient;
import com.mindtree.Consumer.model.Consumer;
import com.mindtree.Consumer.repositorydao.ConsumerRepo;
import com.mindtree.Consumer.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
		/*
			 http://localhost:8931/consumer/*

		 To Access from Zuul API Gateway
	 http://localhost:8989/onlineStore/consumerService/consumer/getConsumers
*/
	@Autowired
	ConsumerService consumerService;
	
	@Autowired
	ProducerClient producerClient;

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/hello")
	public String sayHello() {
		consumerService.clear();
		return "Hello Hello";
	}
	
	@GetMapping("/getProducerBy/{name}")
	public Producer getProducerByName(@PathVariable String name){
		
//		Producer prod=restTemplate.getForObject("http://localhost:8930/producer/getProducerBy/"+name, Producer.class);
		
		Producer p1 = producerClient.getProducerBy(name);
		
//		Product product1=restTemplate.getForObject("http://localhost:8932/item/getItems/"+prod.getBrandName(), Product.class);

//		return ratingsList.stream().map(rating-> {
//			Movie movie =restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(), Movie.class);
//			return new Catalog(movie.getName(),"Movie",rating.getRating());
//			}).collect(Collectors.toList());
		
		return p1;		
	}
	
	@GetMapping("/getConsumers")
	public List<Consumer> getConsumer() throws InterruptedException{
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
	public Consumer updateConsumer(@RequestBody Consumer p,@PathVariable int id)throws InterruptedException  {
		return consumerService.updateConsumer(p,id);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	/*	
	@GetMapping("/SearchSkill")
	public List<SkillsTechnologiesRepositorydao>searchSkills(){
		
		return null;//TODO
	}
	*/
	


	//Input
	/*
	 * id searchString
	 */
//Output
	/*
	 * Skill Matching skills array
	 */
//Note: If search string is empty retrieve all Skills

}
