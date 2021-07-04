package com.hcl.capstone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.capstone.dto.CartDTO;
import com.hcl.capstone.entity.Cart;
import com.hcl.capstone.exception.CartException;
import com.hcl.capstone.service.ICartService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private ICartService iCartService;
	
	@PostMapping("/addToCart")
	public ResponseEntity<Cart> addNewItemInCart(@RequestBody Cart cart) throws CartException {
		Cart cart1 = iCartService.addToCart(cart);
		log.info("Item added to cart successfully");
		return new ResponseEntity<Cart>(cart1, HttpStatus.OK);
	}
	
	@GetMapping("/getCartByUserId/{userId}")
	public ResponseEntity<List<CartDTO>> getCartByUserId(@PathVariable("userId") long userId) {
		List<CartDTO> cartDTOList = new ArrayList<CartDTO>();
		List<Cart> cartList = iCartService.findCartByUserId(userId);
		log.info("cart===="+cartList);
		for(Cart cart : cartList) {
			CartDTO cartDTO = new CartDTO();
	
			cartDTO.setFoodId(cart.getMenu().getFoodId());
			cartDTO.setFoodName(cart.getMenu().getFoodName());
			cartDTO.setFoodCategeory(cart.getMenu().getFoodCategeory());
			cartDTO.setFoodPrice(cart.getMenu().getFoodPrice());
			cartDTO.setImageUrl(cart.getMenu().getImageUrl());
			cartDTO.setUserId(cart.getUser().getId());
			cartDTO.setFirstName(cart.getUser().getFirstName());
			cartDTO.setRestaurentName(cart.getMenu().getRestaurant().getRestaurentName());
			
			cartDTOList.add(cartDTO);
		}
		return new ResponseEntity<List<CartDTO>>(cartDTOList, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCartDetail/{userId}")
	public ResponseEntity<Object> deleteCart(@PathVariable("userId") long userId){
		iCartService.removeFromCartByUserId(userId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/getCartById/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable("id") long id) throws CartException{
		Cart cart1 = iCartService.findCartById(id);
		return new ResponseEntity<Cart>(cart1, HttpStatus.OK);
	}

}
