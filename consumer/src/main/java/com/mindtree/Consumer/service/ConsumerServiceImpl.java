package com.mindtree.Consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindtree.Consumer.entity.Consumer;
import com.mindtree.Consumer.repositorydao.ConsumerRepo;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	ConsumerRepo consumerRepo;

	@Override
	public List<Consumer> getAllData() throws InterruptedException {
		return consumerRepo.findAll();
	}
	
//	@CacheEvict(value = "Consumers", allEntries = true)
//	@Override
//	public void clear() {
//	}

	@Override
	public Consumer addConsumer(Consumer p) {
		return consumerRepo.save(p);
	}

	@Override
	@CacheEvict(value = "Consumers", allEntries = true)
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		consumerRepo.deleteById(id);
		return true;
	}

	@Override
	@CachePut(value = "Consumer")
	public Consumer updateConsumer(Consumer p,int id) throws InterruptedException {
		Consumer res =consumerRepo.findById(id).orElse(null);
		if(res!=null) {
			res.setName(p.getName());
			consumerRepo.save(res);
			return res;
		}
		return null;
	}

}
