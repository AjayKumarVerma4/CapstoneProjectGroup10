package com.hcl.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.capstone.entity.Restaurant;

@Repository("restaurantRepository")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


}
