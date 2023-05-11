package com.ex.base.controllers;

import com.ex.base.entity.Reviews;
import com.ex.base.jpa.ReviewsRepository;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="/reviews", description="Review endpoints")
@RestController
public class ReviewsController {

    @Autowired
    private ReviewsRepository reviewRepository;

    @GetMapping(value = "/reviews")
    public ResponseEntity getReviews() {
        List<Reviews> total = new ArrayList<Reviews>();
        reviewRepository.findAll().forEach(total::add);
        return ResponseEntity.ok(total);
    }

    @GetMapping(value = "/review")
    public ResponseEntity getReview(@RequestParam(value ="id") Long id) {
        Reviews review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(review);
        }
    }

    @PostMapping("/review")
    public Reviews createReview(@RequestBody Reviews reviewRequest) {
        Integer restaurant_id = reviewRequest.getRestaurant_id();
        Integer customer_id = reviewRequest.getCustomer_id();
        Integer reservation_id = reviewRequest.getReservation_id();
        Integer score = reviewRequest.getScore();
        String content = reviewRequest.getContent();

        Reviews review = new Reviews(null, restaurant_id, customer_id, reservation_id, score, content);
        return reviewRepository.save(review);
    }

    @PutMapping(value = "/review/{id}")
    public ResponseEntity updateReview(@PathVariable(value = "id") Long id, @RequestBody Reviews updatedReview) {
        Reviews review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            return ResponseEntity.notFound().build();
        } else {
            review.setRestaurant_id(updatedReview.getRestaurant_id());
            review.setCustomer_id(updatedReview.getCustomer_id());
            review.setReservation_id(updatedReview.getReservation_id());
            review.setScore(updatedReview.getScore());
            review.setContent(updatedReview.getContent());
            reviewRepository.save(review);
            return ResponseEntity.ok(review);
        }
    }

    @DeleteMapping(value = "/review")
    public ResponseEntity removeReview(@RequestParam(value ="id") Long id) {
        Reviews review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            return ResponseEntity.notFound().build();
        } else {
            reviewRepository.delete(review);
            return ResponseEntity.ok().build();
        }
    }

}