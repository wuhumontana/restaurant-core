package com.ex.base.controllers;

import com.ex.base.entity.Seating;
import com.ex.base.jpa.SeatingRepository;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="/seating", description="Table endpoints")
@RestController
public class SeatingController {

    @Autowired
    private SeatingRepository seatingRepository;

    @GetMapping(value = "/table")
    public ResponseEntity getTable(@RequestParam(value ="id") Long id) {
        Seating tables = seatingRepository.findById(id).orElse(null);
        if (tables == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tables);
        }
    }

    @PostMapping("/table")
    public Seating createTable(@RequestBody Seating seatingRequest) {
        Integer restaurant_id = seatingRequest.getRestaurant_id();
        Integer table_number = seatingRequest.getTable_number();
        Integer table_size = seatingRequest.getTable_size();
        Integer capacity = seatingRequest.getCapacity();
        Integer status = seatingRequest.getStatus();

        Seating seat = new Seating();
        seat.setRestaurant_id(restaurant_id);
        seat.setTable_number(table_number);
        seat.setTable_size(table_size);
        seat.setCapacity(capacity);
        seat.setStatus(status);
        
        return seatingRepository.save(seat);
    }

    @PutMapping(value = "/table/{id}")
    public ResponseEntity updateTable(@PathVariable(value = "id") Long id, @RequestBody Seating updatedSeating) {
        Seating tables = seatingRepository.findById(id).orElse(null);
        if (tables == null) {
            return ResponseEntity.notFound().build();
        } else {
            tables.setRestaurant_id(updatedSeating.getRestaurant_id());
            tables.setTable_number(updatedSeating.getTable_number());
            tables.setTable_size(updatedSeating.getTable_size());
            tables.setCapacity(updatedSeating.getCapacity());
            tables.setStatus(updatedSeating.getStatus());
            seatingRepository.save(tables);
            return ResponseEntity.ok(tables);
        }
    }

    @DeleteMapping(value = "/table")
    public ResponseEntity removeTable(@RequestParam(value ="id") Long id) {
        Seating tables = seatingRepository.findById(id).orElse(null);
        if (tables == null) {
            return ResponseEntity.notFound().build();
        } else {
            seatingRepository.delete(tables);
            return ResponseEntity.ok().build();
        }
    }
}
