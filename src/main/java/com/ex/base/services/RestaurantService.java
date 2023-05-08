package com.ex.base.services;

import java.util.List;

import com.ex.base.entity.Restaurant;

public interface RestaurantService {
    List<Restaurant> getRestaurants();
    Restaurant findById(Long id);
}
