package com.ex.base.controllers;

import com.ex.base.entity.reservation;
import com.ex.base.jpa.ApiUserRepository;
import com.ex.base.jpa.myReservationRepository;

import cn.hutool.extra.mail.MailUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Autowired
    private myReservationRepository reservationRepository;
    @Autowired 
    private ApiUserRepository userRepo;

    @GetMapping(value = "/reservation")
    public ResponseEntity getReservation(@RequestParam(value ="id") Long id) {
        reservation reservationns = reservationRepository.findById(id).orElse(null);
        if (reservationns == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(reservationns);
        }
    }

    @PostMapping("/reservation")
    public reservation createReservation(@RequestBody reservation reservationRequest) {
        Integer customer_id = reservationRequest.getCustomerId();
        Integer restaurant_id = reservationRequest.getRestaurantId();
        Integer table_id = reservationRequest.getTableId();
        Integer table_size = reservationRequest.getTableSize();
        String date = reservationRequest.getDate();
        Integer scheduled_time = reservationRequest.getScheduledTime();
        reservation reservations = new reservation(customer_id, restaurant_id, table_id, table_size, date, scheduled_time);
        reservationRepository.save(reservations);
        MailUtil.send(userRepo.findById(Long.valueOf(reservationRequest.getCustomerId())).get().getEmail(), 
                "Reservation-Create", "You have made a reservation successfully!", false);
        return ResponseEntity.ok(reservations);
    }

    @PutMapping(value = "/reservation/{id}")
    public ResponseEntity updateReservation(@PathVariable(value = "id") Long id, @RequestBody reservation updatedReservation) {
        reservation reservations = reservationRepository.findById(id).orElse(null);
        if (reservations == null) {
            return ResponseEntity.notFound().build();
        } else {
            reservations.setCustomerId(updatedReservation.getCustomerId());
            reservations.setRestaurantId(updatedReservation.getRestaurantId());
            reservations.setTableId(updatedReservation.getTableId());
            reservations.setTableSize(updatedReservation.getTableSize());
            reservations.setDate(updatedReservation.getDate());
            reservations.setScheduledTime(updatedReservation.getScheduledTime());
            reservationRepository.save(reservations);
            MailUtil.send(userRepo.findById(Long.valueOf(updatedReservation.getCustomerId())).get().getEmail(), 
                    "Reservation-Update", "Your reservation was updated successfully!", false);
            return ResponseEntity.ok(reservations);
        }
    }

    @DeleteMapping(value = "/reservation")
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