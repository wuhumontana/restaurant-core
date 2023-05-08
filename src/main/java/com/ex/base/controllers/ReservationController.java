package com.ex.base.controllers;

import com.ex.base.entity.reservation;
import com.ex.base.jpa.myReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Autowired
    private myReservationRepository reservationRepository;

    @GetMapping(value = "/reservation")
    public ResponseEntity getReservation(@RequestParam(value ="id") Long id) {
        reservation reservationns = reservationRepository.findById(id).orElse(null);
        if (reservationns == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(reservationns);
        }
    }

    @PostMapping("/reservations")
    public reservation createReservation(@RequestBody reservation reservationRequest) {
        Integer customer_id = reservationRequest.getCustomerId();
        Integer restaurant_id = reservationRequest.getRestaurantId();
        Integer table_id = reservationRequest.getTableId();
        Integer scheduled_time = reservationRequest.getScheduledTime();

        reservation reservations = new reservation(customer_id, restaurant_id, table_id, scheduled_time);
        return reservationRepository.save(reservations);
    }

    @PutMapping(value = "/updatereservation/{id}")
    public ResponseEntity updateReservation(@PathVariable(value = "id") Long id, @RequestBody reservation updatedReservation) {
        reservation reservations = reservationRepository.findById(id).orElse(null);
        if (reservations == null) {
            return ResponseEntity.notFound().build();
        } else {
            reservations.setCustomerId(updatedReservation.getCustomerId());
            reservations.setRestaurantId(updatedReservation.getRestaurantId());
            reservations.setTableId(updatedReservation.getTableId());
            reservations.setScheduledTime(updatedReservation.getScheduledTime());
            reservationRepository.save(reservations);
            return ResponseEntity.ok(reservations);
        }
    }

    @DeleteMapping(value = "/deletereservation")
    public ResponseEntity removeReservation(@RequestParam(value ="id") Long id) {
        reservation reservations = reservationRepository.findById(id).orElse(null);
        if (reservations == null) {
            return ResponseEntity.notFound().build();
        } else {
            reservationRepository.delete(reservations);
            return ResponseEntity.ok().build();
        }
    }
}