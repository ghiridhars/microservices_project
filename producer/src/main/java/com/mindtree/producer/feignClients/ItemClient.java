package com.mindtree.producer.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.producer.model.Item;
import com.mindtree.producer.model.Product;

@Service
@FeignClient(value = "itemService"
		,url = "http://localhost:8932/item"
		)
public interface ItemClient {

	@GetMapping(value = "/getAllItems")
	public Product getItems();
	
	@GetMapping("/getItemByBrand/{brand}")
	public List<Item> getItemsByBrand(@PathVariable String brand);
	
	@RequestMapping(method = RequestMethod.POST,value="/addItem")
	public Item addItem(@RequestBody Item it);
	
	@RequestMapping(method = RequestMethod.PUT,value="/updateItem/{name}")
	public Item updateItem(@RequestBody Item id,@PathVariable String name);
	
	@DeleteMapping(value = "/deleteItem/{name}")
	public boolean deleteItem(@PathVariable String name);
	
}
