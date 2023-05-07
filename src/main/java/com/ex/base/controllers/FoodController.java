package com.ex.base.controllers;

import com.ex.base.entity.food;
import com.ex.base.jpa.myFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {

    @Autowired
    private myFoodRepository foodRepository;

    @GetMapping(value = "/menu")
    public ResponseEntity getFood(@RequestParam(value ="id") Long id) {
        food foodd = foodRepository.findById(id).orElse(null);
        if (foodd == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foodd);
        }
    }

    @PostMapping("/menus")
    public food createMenu(@RequestBody food menuRequest) {
        String name = menuRequest.getName();
        Integer type = menuRequest.getType();
        Integer price = menuRequest.getPrice();
        Integer status = menuRequest.getStatus();

        food menu = new food(name, type, price, status);
        return foodRepository.save(menu);
    }

    @PutMapping(value = "/updatemenu/{id}")
    public ResponseEntity updateMenu(@PathVariable(value = "id") Long id, @RequestBody food updatedFood) {
        food menu = foodRepository.findById(id).orElse(null);
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

    @DeleteMapping(value = "/deletemenuitem")
    public ResponseEntity removeMenu(@RequestParam(value ="id") Long id) {
        food menu = foodRepository.findById(id).orElse(null);
        if (menu == null) {
            return ResponseEntity.notFound().build();
        } else {
            foodRepository.delete(menu);
            return ResponseEntity.ok().build();
        }
    }

}