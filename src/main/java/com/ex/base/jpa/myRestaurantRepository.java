package com.ex.base.jpa;

import com.ex.base.entity.restaurant;
import org.springframework.data.repository.CrudRepository;

public interface myRestaurantRepository extends CrudRepository<restaurant, Long> {
}