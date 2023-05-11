package com.ex.base.controllers;

import com.ex.base.entity.Reservation;
import com.ex.base.jpa.ApiUserRepository;
import com.ex.base.jpa.ReservationRepository;

import cn.hutool.extra.mail.MailUtil;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="/reservation", description="Reservation endpoints")
@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired 
    private ApiUserRepository userRepo;

    @GetMapping(value = "/reservations")
    public ResponseEntity<List<Reservation>> getRestaurants() {
        List<Reservation> total = new ArrayList<Reservation>();
        reservationRepository.findAll().forEach(total::add);
        return ResponseEntity.ok(total);
    }

    @GetMapping(value = "/reservation")
    public ResponseEntity getReservation(@RequestParam(value ="id") Long id) {
        Reservation reservationns = reservationRepository.findById(id).orElse(null);
        if (reservationns == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(reservationns);
        }
    }

    @PostMapping("/reservation")
    public Reservation createReservation(@RequestBody Reservation reservationRequest) {
        System.out.println("---- ReservationController::createReservation");
        Integer customer_id = reservationRequest.getCustomer_id();
        Integer restaurant_id = reservationRequest.getRestaurant_id();
        Integer table_id = reservationRequest.getTable_id();
        Integer table_size = reservationRequest.getTable_size();
        String date = reservationRequest.getDate();
        Integer scheduled_time = reservationRequest.getScheduled_time();
        Reservation reservations = new Reservation(null, customer_id, restaurant_id, table_id, table_size, date, scheduled_time);
        return reservationRepository.save(reservations);
//        MailUtil.send(userRepo.findById(Long.valueOf(reservationRequest.getCustomerId())).get().getEmail(),
//                "Reservation-Create", "You have made a reservation successfully!", false);
//        return reservations;
    }

    @PutMapping(value = "/reservation/{id}")
    public ResponseEntity updateReservation(@PathVariable(value = "id") Long id, @RequestBody Reservation updatedReservation) {
        Reservation reservations = reservationRepository.findById(id).orElse(null);
        if (reservations == null) {
            return ResponseEntity.notFound().build();
        } else {
            reservations.setCustomer_id(updatedReservation.getCustomer_id());
            reservations.setRestaurant_id(updatedReservation.getRestaurant_id());
            reservations.setTable_id(updatedReservation.getTable_id());
            reservations.setTable_size(updatedReservation.getTable_size());
            reservations.setDate(updatedReservation.getDate());
            reservations.setScheduled_time(updatedReservation.getScheduled_time());
            Reservation result = reservationRepository.save(reservations);
            return ResponseEntity.ok(result);
            // MailUtil.send(userRepo.findById(Long.valueOf(updatedReservation.getCustomerId())).get().getEmail(), 
            //         "Reservation-Update", "Your reservation was updated successfully!", false);
            // return ResponseEntity.ok(reservations);
        }
    }

    @DeleteMapping(value = "/reservation")
    public ResponseEntity removeReservation(@RequestParam(value ="id") Long id) {
        Reservation reservations = reservationRepository.findById(id).orElse(null);
        if (reservations == null) {
            return ResponseEntity.notFound().build();
        } else {
            reservationRepository.delete(reservations);
            return ResponseEntity.ok().build();
        }
    }
}