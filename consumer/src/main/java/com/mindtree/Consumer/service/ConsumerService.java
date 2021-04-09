package com.mindtree.Consumer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Consumer.entity.Consumer;

@Service
public interface ConsumerService {

	List<Consumer> getAllData() throws InterruptedException;

	Consumer addConsumer(Consumer p);
	
	boolean deleteById(int id);

	Consumer updateConsumer(Consumer p, int id) throws InterruptedException;
	
	void clear();

}
