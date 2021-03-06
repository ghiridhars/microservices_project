package com.mindtree.Consumer.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.Consumer.model.Item;
import com.mindtree.Consumer.model.Product;

@Service
@FeignClient(value = "itemService", url = "http://localhost:8989/onlineStore/itemService/item")
public interface ItemClient {

	@GetMapping(value = "/getItems/{name}")
	public List<Item> getItemBy(@PathVariable String name);

	@GetMapping(value = "/getAllItems")
	public List<Item> getItems();

	@GetMapping(value = "/getItemById/{id}")
	public Item getItemById(@PathVariable int id);
	
	@GetMapping(value = "/getItemByName/{i_name}")
	public Item getItemByName(String i_name);

}
