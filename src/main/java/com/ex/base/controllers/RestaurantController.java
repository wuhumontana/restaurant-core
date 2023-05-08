package com.ex.base.controllers;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ex.base.entity.Restaurant;
import com.ex.base.jpa.RestaurantRepository;
import com.ex.base.services.RestaurantService;

@RestController
public class RestaurantController {
	private final AtomicLong counter = new AtomicLong();

    @Autowired private RestaurantRepository repo;
    // @Autowired private RestaurantService restaurantService;

	@GetMapping(value = "/restaurants/")
	public ResponseEntity index() {

        System.out.println("+++++++++++++++++++ RestaurantController GET ++++++++++++++++");

        try {
            List<Restaurant> restaurants = repo.getRestaurants().get();
            return ResponseEntity.ok(restaurants);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 not found
        }
	}
	
    @GetMapping(value = "/restaurants/{id}")
    public ResponseEntity getRestaurantById(@PathVariable(value="id") Long id) {
        System.out.println("geta saFASFSDGSDXS");
        Restaurant itemToReturn = null;
        List<Restaurant> restaurants = repo.getRestaurants().get();
        for(Restaurant rest : restaurants) {
            if(rest.getId() == id)
                itemToReturn = rest;
        }
        boolean matchExists = restaurants.stream()
        		.map(c -> c.getId())
        		.anyMatch(x->x==id);
       	if (matchExists) {
    		return ResponseEntity.ok(itemToReturn);
    	} else {
    		return ResponseEntity.notFound().build(); // 404 not found
    	}
    }
    
    @PostMapping(value = "/restaurants/")
    public Restaurant addToRestaurants(@RequestBody Restaurant restaurantRequest
            // @RequestParam(value="name") String name, 
            // @RequestParam(value="account") String account, 
            // @RequestParam(value="password") String password, 
            // @RequestParam(value="description") String description, 
            // @RequestParam(value="mobile") String mobile,
            // @RequestParam(value="address") String address,
            // @RequestParam(value="imageUrl") String imageUrl,
            // @RequestParam(value="openTime") Integer openTime, 
            // @RequestParam(value="closeTime") Integer closeTime, 
            // @RequestParam(value="status") Integer status
        ) {
        System.out.println("addToRestaurants hit!");
        Long id = counter.getAndIncrement();
        Restaurant rest = new Restaurant(restaurantRequest.getId(), 
        restaurantRequest.getName(), 
        restaurantRequest.getAccount(), 
        restaurantRequest.getPassword(), 
        restaurantRequest.getDescription(),
        restaurantRequest.getMobile(), 
        restaurantRequest.getAddress(), 
        restaurantRequest.getImageUrl(), 
        restaurantRequest.getOpenTime(), 
        restaurantRequest.getCloseTime(), 
        restaurantRequest.getStatus()
        );
        // List<Restaurant> restaurants = restaurantService.getRestaurants();
        // restaurants.add(rest);
        return repo.save(rest); // Saves to database
        // URI location = ServletUriComponentsBuilder
        //         .fromCurrentRequestUri().path("/{id}")
        //         .buildAndExpand(rest.getId()).toUri();

        // return ResponseEntity
        // 		.status(HttpStatus.CREATED)
        // 		.location(location)
        // 		.body(rest);
    }
    
    // Needs to be tested. 
    // [ ] Unsure of Date datatype (will it work?)
    // [ ] Plain text password and account info not ideal
    @PutMapping(value = "/restaurants/{id}")
    public ResponseEntity updateRestaurant(@PathVariable(value="id") Long id, 
    		@RequestParam(value="name") String name, 
            @RequestParam(value="account") String account, 
            @RequestParam(value="password") String password, 
            @RequestParam(value="description") String description, 
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="address") String address,
            @RequestParam(value="imageUrl") String imageUrl,
            @RequestParam(value="openTime") Integer openTime, 
            @RequestParam(value="closeTime") Integer closeTime, 
            @RequestParam(value="status") Integer status) {
        List<Restaurant> restaurants = repo.getRestaurants().get();
        restaurants.forEach(rest ->  {
            if(rest.getId() == id) {
                rest.setName(name);
                rest.setAccount(account);
                rest.setPassword(password);
                rest.setDescription(description);
                rest.setMobile(mobile);
                rest.setAddress(address);
                rest.setImageUrl(imageUrl);
                rest.setOpenTime(openTime);
                rest.setCloseTime(closeTime);
                rest.setStatus(status);
            }
        });
        return ResponseEntity.ok(restaurants);
    }
    
    @DeleteMapping(value = "/restaurants/{id}")
    public ResponseEntity removeRestaurant(@PathVariable(value="id") Long id) {
        Restaurant itemToRemove = null;
        List<Restaurant> restaurants = repo.getRestaurants().get();

        for(Restaurant rest : restaurants){
            if(rest.getId() == id)
                itemToRemove = rest;
        }
        restaurants.remove(itemToRemove);
        return ResponseEntity.ok(restaurants);
    }
}
