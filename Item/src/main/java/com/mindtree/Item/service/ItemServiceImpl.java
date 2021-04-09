package com.mindtree.Item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindtree.Item.entity.Item;
import com.mindtree.Item.repositorydao.ItemRepo;

@Service
@CacheConfig(cacheNames="items")
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepo itemRepo;

	@Override
	@Cacheable
	public List<Item> getAllData() throws InterruptedException {
		Thread.sleep(900);
		return itemRepo.findAll();
	}
	
	@CacheEvict(allEntries = true)
	@Override
	public void clear() {
	}

	@Override
	public Item addItem(Item p) {
		return itemRepo.save(p);
	}

	@Override
	public List<Item> getByType(String prod) {
		return itemRepo.getByType(prod);
	}

	@Override
	public boolean deleteById(int id) {
		itemRepo.deleteById(id);
		return true;
	}

	@Override
	public Item updateItem(Item p, int id) {
		Item res =itemRepo.findById(id).orElse(null);
		if(res!=null) {
			res.setName(p.getName());
			itemRepo.save(res);
			return res;
		}
		return null;
	}
}
