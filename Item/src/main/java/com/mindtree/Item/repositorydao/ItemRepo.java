package com.mindtree.Item.repositorydao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.Item.entity.Item;


public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	@Query("Select i from Item i where i.itemType=?1")
	public List<Item> getByType(String type);
	
	@Query("Select i from Item i where i.name=?1")
	public Optional<Item> findByName(String name);
	
	
}
