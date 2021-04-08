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
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.producer.model.Producer;
import com.mindtree.producer.repositorydao.ProducerRepo;
import com.mindtree.producer.service.ProducerService;


@RestController
@RequestMapping("/producer")
public class ProducerController {
		/*
		 
		 http://localhost:8930/producer/*
		 
		 To Access from Zuul API Gateway
	 http://localhost:8989/onlineStore/producerService/producer/*
*/
	
	@Autowired
	ProducerService producerService;
	
	@GetMapping("/hello")
	public String sayHello() {
		producerService.clear();
		return "Hello Hello";
	}
	
	@GetMapping("/getProducerBy/{name}")
	public Producer getProducerBy(@PathVariable String name){
		return producerService.getByName(name);
	}
	
	@GetMapping("/getProducer/{id}")
	public Producer getProducerBy(@PathVariable int id){
		return producerService.getById(id);
	}
	
	@GetMapping("/getProducers")
	public List<Producer> getSkill() throws InterruptedException {
		return producerService.getAllData();
	}
	
	@PostMapping("/addProducer")
	public Producer addProducer(@RequestBody Producer p) {
		producerService.clear();
		return producerService.addProducer(p);
	}
	
	@DeleteMapping("/deleteProducer/{id}")
	public boolean delteProducer(@PathVariable int id) {
		return producerService.deleteById(id);
	}
	
	@PutMapping("/updateProducer/{id}")
	public Producer updateProducer(@RequestBody Producer p,@PathVariable int id)throws InterruptedException  {
		return producerService.updateProducer(p,id);
	}
//	@GetMapping("/addProducer")
//	public List<SkillsTechnologiesRepositorydao> searchSkills(){
//		
//		return null;//TODO
//	}
	


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
