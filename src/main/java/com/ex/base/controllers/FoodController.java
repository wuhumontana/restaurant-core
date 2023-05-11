package com.ex.base.controllers;

import com.ex.base.entity.Food;
import com.ex.base.jpa.FoodRepository;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="/menu", description="Menu endpoints")
@RestController
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping(value = "/menu")
    public ResponseEntity getFood(@RequestParam(value ="id") Long id) {
        Food foodd = foodRepository.findById(id).orElse(null);
        if (foodd == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foodd);
        }
    }

    @PostMapping("/menu")
    public Food createMenu(@RequestBody Food menuRequest) {
        Food menu = new Food();
        menu.setName(menuRequest.getName());
        menu.setType(menuRequest.getType());
        menu.setPrice(menuRequest.getPrice());
        menu.setStatus(menuRequest.getStatus());

        return foodRepository.save(menu);
    }

    @PutMapping(value = "/menu/{id}")
    public ResponseEntity updateMenu(@PathVariable(value = "id") Long id, @RequestBody Food updatedFood) {
        Food menu = foodRepository.findById(id).orElse(null);
        if (menu == null) {
            return ResponseEntity.notFound().build();
        } else {
            menu.setName(updatedFood.getName());
            menu.setType(updatedFood.getType());
            menu.setPrice(updatedFood.getPrice());
            menu.setStatus(updatedFood.getStatus());
            foodRepository.save(menu);
            return ResponseEntity.ok(menu);
        }
    }

    @DeleteMapping(value = "/menu")
    public ResponseEntity removeMenu(@RequestParam(value ="id") Long id) {
        Food menu = foodRepository.findById(id).orElse(null);
        if (menu == null) {
            return ResponseEntity.notFound().build();
        } else {
            foodRepository.delete(menu);
            return ResponseEntity.ok().build();
        }
    }
}