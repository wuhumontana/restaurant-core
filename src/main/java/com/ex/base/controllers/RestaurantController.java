package com.ex.base.controllers;

import com.ex.base.entity.restaurant;
import com.ex.base.jpa.myRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    private myRestaurantRepository restaurantRepository;

    @GetMapping(value = "/restaurant")
    public ResponseEntity getRestaurant(@RequestParam(value ="id") Long id) {
        restaurant restaurantd = restaurantRepository.findById(id).orElse(null);
        if (restaurantd == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(restaurantd);
        }
    }

    @PostMapping("/restaurant")
    public restaurant createRestaurant(@RequestBody restaurant restaurantRequest) {
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

        restaurant restaurants = new restaurant(name, account, password, description,
                                                mobile, address, tablesAvailable,
                                                tablesAvailableSZ2, image_url, hours, status);
        return restaurantRepository.save(restaurants);
    }

    @PutMapping(value = "/restaurant/{id}")
    public ResponseEntity updateRestaurant(@PathVariable(value = "id") Long id, @RequestBody restaurant updatedRestaurant) {
        restaurant restaurants = restaurantRepository.findById(id).orElse(null);
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
        restaurant restaurants = restaurantRepository.findById(id).orElse(null);
        if (restaurants == null) {
            return ResponseEntity.notFound().build();
        } else {
            restaurantRepository.delete(restaurants);
            return ResponseEntity.ok().build();
        }
    }

}