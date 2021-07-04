package com.hcl.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entity.Cart;
import com.hcl.capstone.entity.Menu;
import com.hcl.capstone.entity.User;
import com.hcl.capstone.exception.CartException;
import com.hcl.capstone.repository.CartRepository;

@Service("cartServiceImpl")
public class CartServiceImpl implements ICartService {
	
	 @Autowired
	 private CartRepository cartRepository;

	@Override
	public Cart addToCart(Cart cart) throws CartException {
		if(!searchByFoodIdAndUserId(cart.getMenu(), cart.getUser()))
			 return cartRepository.saveAndFlush(cart);
		else
			throw new CartException("This food already added to the cart");
	}

	private boolean searchByFoodIdAndUserId(Menu foodId, User user) {
		boolean b=false;
		Cart cart=cartRepository.findByFoodIdAndUserId(foodId, user);
		if(cart != null) {
			b=true;
		}
		return b;
	}

	@Override
	public List<Cart> findCartByUserId(long userId) {
			return cartRepository.findCartByUserId(userId);
	}


	@Override
	public void removeFromCartByUserId(long userId) {
		cartRepository.removeFromCartByUserId(userId);
		
	}

	@Override
	public Cart findCartById(long id) throws CartException {
		if (cartRepository.findById(id).isPresent())
			return cartRepository.findById(id).get();
		else
			throw new CartException("food does not exist");
	}

}
