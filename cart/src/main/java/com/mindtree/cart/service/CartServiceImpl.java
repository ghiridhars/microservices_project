package com.mindtree.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindtree.cart.entity.Cart;
import com.mindtree.cart.model.Item;
import com.mindtree.cart.repositorydao.CartRepo;

@Service
@CacheConfig(cacheNames = "cart")
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepo cartRepo;

	@Override
	@Cacheable
	public Cart getCartData(int id) {
		return cartRepo.findById(id).orElse(null);
	}

	@Override
	public Cart addItem(Item p, int c_id) {
		Cart c = cartRepo.findById(c_id).orElse(null);

		if (c == null) {
			Cart c_new = new Cart();
			List<Integer> x = new ArrayList<>();
			x.add(p.getId());
			c_new.setItem_id(x);
			c_new.setId(c_id);
			return cartRepo.save(c_new);
		} else {
			List<Integer> x = new ArrayList<>();
			float total = c.getTotal();
			if (c.getItem_id().size() != 0) {
				x = c.getItem_id();
			}
			x.add(p.getId());
			c.setItem_id(x);
			total += (p.getPrice_per_quantity());
			c.setTotal(total);
			System.out.println(c);
			return cartRepo.save(c);
		}

	}

	@Override
	public boolean deleteCartById(int id) {
		cartRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean deleteItemById(Item p, int id) {
		Cart c = cartRepo.findById(id).orElse(null);
		if (c != null) {
			List<Integer> x = new ArrayList<>();
			float total = c.getTotal();
			x = c.getItem_id();
			if (x.size() == 0) {
				return false;
			} else {
				if (x.contains(p.getId())) {
					x.remove(x.indexOf(p.getId()));
				} else {
					return false;
				}
			}
			c.setItem_id(x);
			total -= (p.getPrice_per_quantity());
			c.setTotal(total);
			System.out.println(c);
			cartRepo.save(c);
		}
		return true;
	}

	@Override
	public Cart addCart(int cust_id) {
		Cart c = new Cart();
		c.setId(cust_id);
		return cartRepo.save(c);
	}

//	@Override
//	public Cart updateItem(Cart p, int id) {
//		Cart res =itemRepo.findById(id).orElse(null);
//		if(res!=null) {
//			res.setName(p.getName());
//			cartRepo.save(res);
//			return res;
//		}
//		return null;
//	}
}
