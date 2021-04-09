package com.mindtree.producer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindtree.producer.entity.Producer;
import com.mindtree.producer.repositorydao.ProducerRepo;

@Service
public class ProducerServiceImpl implements ProducerService{
	
	@Autowired
	ProducerRepo producerRepo;

	@Override
	@Cacheable(value="producers", key="#name", condition="#name!='Apple'" , unless="#result==null")
	public Producer getByName(String name) {
		return producerRepo.findByName(name);
	}
	
	@Override
	@Cacheable(value="producers", key="#id")
	public Producer getById(int id) {
		return producerRepo.findById(id).orElse(null);
	}

	@Override
	@Cacheable(value="producers")
	public List<Producer> getAllData() throws InterruptedException {
		Thread.sleep(950);
		return producerRepo.findAll();
	}
	
	@CacheEvict(value = "producers", allEntries = true)
	@Override
	public void clear() {
	}

	@Override
	public Producer addProducer(Producer p) {
		return producerRepo.save(p);
	}

	@Override
	@CacheEvict(value = "producers", allEntries = true)
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		producerRepo.deleteById(id);
		return true;
	}

	@Override
	@CachePut(value = "producers",key = "#id")
	public Producer updateProducer(Producer p,int id) throws InterruptedException {
		Producer res =producerRepo.findById(id).orElse(null);
		if(res!=null) {
			res.setName(p.getName());
			res.setBrandName(p.getBrandName());
			producerRepo.save(res);
			return res;
		}
		return null;
	}

}
