package com.mindtree.cart.repositorydao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.cart.entity.Cart;


public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	@Query("Select i from Item i where i.itemType=?1")
	public List<Cart> getByType(String type);
}
