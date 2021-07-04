package com.hcl.capstone.service;

import java.util.List;

import com.hcl.capstone.entity.Cart;
import com.hcl.capstone.exception.CartException;

public interface ICartService {
	
	public Cart addToCart(Cart cart) throws CartException;
	
	public List<Cart> findCartByUserId(long userId);
		
	public void removeFromCartByUserId(long userId);
		
	public Cart findCartById(long id) throws CartException;

}
