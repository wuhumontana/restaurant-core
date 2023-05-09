package com.ex.base.jpa;

import com.ex.base.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface myRestaurantRepository extends CrudRepository<Restaurant, Long> {
}