package com.mindtree.Item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindtree.Item.entity.Item;
import com.mindtree.Item.exception.ItemMicroserviceException;
import com.mindtree.Item.exception.ItemServiceException;
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
	public List<Item> getByType(String prod) throws ItemServiceException {
		List<Item> items= itemRepo.getByType(prod);
		if(items.size() ==0) {
			throw new ItemServiceException("No items found");
		}
		else return items;
	}

	@Override
	public boolean deleteByName(String name) throws ItemServiceException {
		Item res =itemRepo.findByName(name).orElseThrow(() -> new ItemServiceException("Item Not Found"));
		System.out.println(res);
		itemRepo.delete(res);
		return true;
	}

	@Override
	public Item updateItem(Item p, String name) throws ItemServiceException {
		Item res =itemRepo.findByName(name).orElseThrow(() -> new ItemServiceException("Item Not Found"));
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
	public Item getById(int id) throws ItemServiceException {
		return itemRepo.findById(id).orElseThrow(() -> new ItemServiceException("Item Not Found"));
	}

	@Override
	public Item getItemByName(String name) throws ItemServiceException {
		// TODO Auto-generated method stub
		return itemRepo.findByName(name).orElseThrow(() -> new ItemServiceException("Item Not Found"));
	}

	@Override
	public List<Item> getAllItemsById(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemByBrand(String brand) throws ItemServiceException {
		// TODO Auto-generated method stub
		return itemRepo.findByBrand(brand).orElseThrow(() -> new ItemServiceException("Item Not Found"));
	}
}
