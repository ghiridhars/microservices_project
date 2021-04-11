package com.mindtree.Consumer.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.Consumer.model.Cart;

@Service
@FeignClient(name = "cartService", url = "http://localhost:8934/cart")
public interface CartClient {

	@PostMapping("/addCart/{c_id}")
	public Cart addCart(@PathVariable int c_id);

	@GetMapping(value = "/getCart/{id}")
	public Cart getItemsCart(@PathVariable int id);

	@RequestMapping(method = RequestMethod.PUT, value = "/addItemToCart/{id}/{c_id}")
	public Cart addItemToCart(@PathVariable int id, @PathVariable int c_id);

	@PutMapping("/deleteItem/{id}/{c_id}")
	public boolean deleteItem(@PathVariable int id, @PathVariable int c_id);

}
