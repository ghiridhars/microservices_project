package com.mindtree.Item.repositorydao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.Item.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	@Query("Select i from Item i where i.itemType=?1")
	public List<Item> getByType(String type);
}
