package com.hcl.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entity.Restaurant;
import com.hcl.capstone.exception.RestaurantException;
import com.hcl.capstone.repository.RestaurantRepository;

//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
@Service("restaurantService")
public class RestaurantServiceImpl implements IRestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	// display list of all restaurant
	@Override
	public List<Restaurant> displayAllRestaurant() {
		return  restaurantRepository.findAll();
	}

	// add new restaurant
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return  restaurantRepository.saveAndFlush(restaurant);
	}

	// get single restaurant by id
	@Override
	public Restaurant getSingleRestaurantById(long id) throws RestaurantException {
		if(restaurantRepository.findById(id).isPresent())
			return restaurantRepository.findById(id).get();
		else
			throw new RestaurantException("restaurant does not exist");
	}

	// update restaurant
	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException {
		if(restaurantRepository.findById(restaurant.getRestaurentId()).isPresent()) {
		    return restaurantRepository.saveAndFlush(restaurant);
		}else {
			throw new RestaurantException("restaurant does not exist");
		}
	}

	// delete restaurant by id
	@Override
	public void deleteRestaurantById(long id) throws RestaurantException {
		if(restaurantRepository.findById(id).isPresent())
			restaurantRepository.deleteById(id);
		else
			throw new RestaurantException("employee already deleted");
	}

}
