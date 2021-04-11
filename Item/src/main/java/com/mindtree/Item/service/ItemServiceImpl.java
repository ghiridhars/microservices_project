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
	public List<Item> getAllData() {
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
	public boolean deleteByName(String name) {
		Item res =itemRepo.findByName(name).orElse(null);
		System.out.println(res);
		itemRepo.delete(res);
		return true;
	}

	@Override
	public Item updateItem(Item p, String name) {
		Item res =itemRepo.findByName(name).orElse(null);
		System.out.println(res);
		if(res!=null) {
			res.setName(p.getName());
			res.setItemType(p.getItemType());
			res.setPrice_per_quantity(p.getPrice_per_quantity());
			itemRepo.save(res);
			return res;
		}
		return null;
	}

	@Override
	public Item getById(int id) {
		return itemRepo.findById(id).orElse(null);
	}

	@Override
	public Item getItemByName(String name) {
		// TODO Auto-generated method stub
		return itemRepo.findByName(name).orElse(null);
	}

	@Override
	public List<Item> getAllItemsById(List<Integer> ids) {
		// TODO Auto-generated method stub
		return itemRepo.findAllById(ids);
	}
}
