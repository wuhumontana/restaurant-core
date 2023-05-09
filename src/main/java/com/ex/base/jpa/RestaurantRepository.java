package com.ex.base.jpa;

import com.ex.base.entity.restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<restaurant, Long> {
}