package com.mindtree.Consumer.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.Consumer.VO.Producer;
import com.mindtree.Consumer.VO.Product;

@Service
@FeignClient(name = "itemService",
		url = "http://localhost:8989/onlineStore/itemService/item")
public interface ItemClient {

	@GetMapping(value = "/getItems/{name}")
	public Product getItemBy(@PathVariable String name);
}