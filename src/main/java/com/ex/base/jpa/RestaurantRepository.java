package com.ex.base.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.base.entity.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    @Query(value = "SELECT r FROM Restaurant r where r.id = ?1")
    Optional<Restaurant> findRestaurantById(Long id);

    @Query(value = "SELECT r FROM Restaurant r")
    Optional<List<Restaurant>> getRestaurants();
}