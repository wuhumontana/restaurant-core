package com.ex.base.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ex.base.entity.Restaurant;
import com.ex.base.jpa.RestaurantRepository;

public class RestaurantServiceImpl implements RestaurantService {
    
    @Autowired
    RestaurantRepository restaurantRepository;
    
    @Override
    public Restaurant findById(Long id) {
        
        System.out.println("********************    " + "in RestrauantServiceImpl, findByID " + "id= " + id);
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        
        System.out.println("%%%%%%%%%%%%%  " + "restaurant  = " + restaurant.toString());
        
        return restaurant.get();
    }

    @Override
    public List<Restaurant> getRestaurants() {
        System.out.println("getRestaurants");
        Optional<List<Restaurant>> restaurants = restaurantRepository.getRestaurants();
        return restaurants.get();
    }
    
}