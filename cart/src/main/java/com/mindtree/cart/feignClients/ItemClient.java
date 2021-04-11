package com.mindtree.cart.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.cart.model.Item;
import com.mindtree.cart.model.Product;

@Service
@FeignClient(name = "itemService",
		url = "http://localhost:8932/item")
public interface ItemClient {

	@GetMapping(value = "/getItems/{name}")
	public Product getItemBy(@PathVariable String name);
	
	@GetMapping(value = "/getItemById/{id}")
	public Item getItemById(@PathVariable int id);

	@GetMapping(value = "/getItemByName/{i_name}")
	public Item getItemByName(String i_name);
}
