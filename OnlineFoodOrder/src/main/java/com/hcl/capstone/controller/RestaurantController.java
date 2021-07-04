package com.hcl.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.capstone.entity.Restaurant;
import com.hcl.capstone.exception.RestaurantException;
import com.hcl.capstone.service.IRestaurantService;

@CrossOrigin
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private IRestaurantService iRestaurantService;
	
	@GetMapping("/restaurantList")
	public ResponseEntity<List<Restaurant>> displayAllRestaurant() {
		List<Restaurant> restaurantList = iRestaurantService.displayAllRestaurant();
		return new ResponseEntity<List<Restaurant>>(restaurantList, HttpStatus.OK);
	}
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addNewRestaurant(@RequestBody Restaurant restaurant){
		Restaurant res = iRestaurantService.addRestaurant(restaurant);
			return new ResponseEntity<Restaurant>(res, HttpStatus.OK);
	}
	
	@GetMapping("/getSingleRestaurant/{id}")
	public ResponseEntity<Restaurant> getSingleRestaurant(@PathVariable("id") long id) throws RestaurantException{
		Restaurant res = iRestaurantService.getSingleRestaurantById(id);
		return new ResponseEntity<Restaurant>(res,HttpStatus.OK);
	}
	
	@PutMapping("/updateRestaurant")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException{
		Restaurant res = iRestaurantService.updateRestaurant(restaurant);
			return new ResponseEntity<Restaurant>(res, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteRestaurant/{id}")
	public ResponseEntity<Object> deleteRestaurant(@PathVariable("id") long id) throws RestaurantException{
		iRestaurantService.deleteRestaurantById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
