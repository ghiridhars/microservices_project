package com.mindtree.producer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.producer.entity.Producer;

@Service
public interface ProducerService {

	Producer getByName(String name);

	List<Producer> getAllData() throws InterruptedException;

	Producer addProducer(Producer p);

	boolean deleteById(int id);

	Producer updateProducer(Producer p, int id) throws InterruptedException;

	void clear();

	Producer getById(int id);

}
