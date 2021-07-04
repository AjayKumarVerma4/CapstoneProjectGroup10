package com.hcl.capstone.service;

import java.util.List;

import com.hcl.capstone.entity.Restaurant;
import com.hcl.capstone.exception.RestaurantException;

public interface IRestaurantService {

	public List<Restaurant> displayAllRestaurant();

	public Restaurant addRestaurant(Restaurant restaurant);

	public Restaurant getSingleRestaurantById(long id) throws RestaurantException;

	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException;

	public void deleteRestaurantById(long id) throws RestaurantException;

}
