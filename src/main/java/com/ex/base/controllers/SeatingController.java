package com.ex.base.controllers;

import com.ex.base.entity.seating;
import com.ex.base.jpa.mySeatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeatingController {

    @Autowired
    private mySeatingRepository seatingRepository;

    @GetMapping(value = "/table")
    public ResponseEntity getTable(@RequestParam(value ="id") Long id) {
        seating tables = seatingRepository.findById(id).orElse(null);
        if (tables == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tables);
        }
    }

    @PostMapping("/table")
    public seating createTable(@RequestBody seating seatingRequest) {
        Integer restaurant_id = seatingRequest.getRestaurantId();
        Integer table_number = seatingRequest.getTableNumber();
        Integer table_size = seatingRequest.getTableSize();
        Integer capacity = seatingRequest.getCapacity();
        Integer status = seatingRequest.getStatus();

        seating tables = new seating(restaurant_id, table_number, table_size, capacity, status);
        return seatingRepository.save(tables);
    }

    @PutMapping(value = "/table/{id}")
    public ResponseEntity updateTable(@PathVariable(value = "id") Long id, @RequestBody seating updatedSeating) {
        seating tables = seatingRepository.findById(id).orElse(null);
        if (tables == null) {
            return ResponseEntity.notFound().build();
        } else {
            tables.setRestaurantId(updatedSeating.getRestaurantId());
            tables.setTableNumber(updatedSeating.getTableNumber());
            tables.setTableSize(updatedSeating.getTableSize());
            tables.setCapacity(updatedSeating.getCapacity());
            tables.setStatus(updatedSeating.getStatus());
            seatingRepository.save(tables);
            return ResponseEntity.ok(tables);
        }
    }

    @DeleteMapping(value = "/table")
    public ResponseEntity removeTable(@RequestParam(value ="id") Long id) {
        seating tables = seatingRepository.findById(id).orElse(null);
        if (tables == null) {
            return ResponseEntity.notFound().build();
        } else {
            seatingRepository.delete(tables);
            return ResponseEntity.ok().build();
        }
    }
}