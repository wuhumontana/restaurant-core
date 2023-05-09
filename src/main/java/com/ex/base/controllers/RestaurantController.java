package com.ex.base.controllers;

import com.ex.base.entity.Restaurant;
import com.ex.base.jpa.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;


    @GetMapping(value = "/restaurants")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        List<Restaurant> total = new ArrayList<Restaurant>();
        restaurantRepository.findAll().forEach(total::add);
        return ResponseEntity.ok(total);
    }

    @GetMapping(value = "/restaurant")
    public ResponseEntity getRestaurant(@RequestParam(value ="id") Long id) {
        Restaurant restaurantd = restaurantRepository.findById(id).orElse(null);
        if (restaurantd == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(restaurantd);
        }
    }

    @PostMapping("/restaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurantRequest) {
        // Iterable<restaurant> restaurants = restaurantRepository.findAll();
        // for (restaurant r: restaurants) {
        //     if (r.getName()==restaurantRequest.getName()) {
        //         return Exception("AlreadyExistsException");
        //     }
        // }
        // if (restaurantRequest.getName() 
        String name = restaurantRequest.getName();
        String account = restaurantRequest.getAccount();
        String password = restaurantRequest.getPassword();
        String description = restaurantRequest.getDescription();
        String mobile = restaurantRequest.getMobile();
        String address = restaurantRequest.getAddress();
        Integer tablesAvailable = restaurantRequest.getTablesAvailable();
        Integer tablesAvailableSZ2 = restaurantRequest.getTablesAvailableSZ2();
        String image_url = restaurantRequest.getImage_url();
        Integer hours = restaurantRequest.getHours();
        Integer status = restaurantRequest.getStatus();

        Restaurant restaurants = new Restaurant(name, account, password, description,
                                                mobile, address, tablesAvailable,
                                                tablesAvailableSZ2, image_url, hours, status);
        return restaurantRepository.save(restaurants);
    }

    @PutMapping(value = "/restaurant/{id}")
    public ResponseEntity updateRestaurant(@PathVariable(value = "id") Long id, @RequestBody Restaurant updatedRestaurant) {
        Restaurant restaurants = restaurantRepository.findById(id).orElse(null);
        if (restaurants == null) {
            return ResponseEntity.notFound().build();
        } else {
            restaurants.setName(updatedRestaurant.getName());
            restaurants.setAccount(updatedRestaurant.getAccount());
            restaurants.setPassword(updatedRestaurant.getPassword());
            restaurants.setDescription(updatedRestaurant.getDescription());
            restaurants.setMobile(updatedRestaurant.getMobile());
            restaurants.setAddress(updatedRestaurant.getAddress());
            restaurants.setTablesAvailable(updatedRestaurant.getTablesAvailable());
            restaurants.setTablesAvailableSZ2(updatedRestaurant.getTablesAvailableSZ2());
            restaurants.setImage_url(updatedRestaurant.getImage_url());
            restaurants.setHours(updatedRestaurant.getHours());
            restaurants.setStatus(updatedRestaurant.getStatus());
            restaurantRepository.save(restaurants);
            return ResponseEntity.ok(restaurants);
        }
    }

    @DeleteMapping(value = "/restaurant")
    public ResponseEntity removeRestaurant(@RequestParam(value ="id") Long id) {
        Restaurant restaurants = restaurantRepository.findById(id).orElse(null);
        if (restaurants == null) {
            return ResponseEntity.notFound().build();
        } else {
            restaurantRepository.delete(restaurants);
            return ResponseEntity.ok().build();
        }
    }

}