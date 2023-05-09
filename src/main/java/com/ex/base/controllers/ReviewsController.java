package com.ex.base.controllers;

import com.ex.base.entity.Reviews;
import com.ex.base.jpa.myReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewsController {

    @Autowired
    private myReviewsRepository reviewRepository;

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
        Integer restaurant_id = reviewRequest.getRestaurantId();
        Integer customer_id = reviewRequest.getCustomerId();
        Integer reservation_id = reviewRequest.getReservationId();
        Integer score = reviewRequest.getScore();
        String content = reviewRequest.getContent();

        Reviews review = new Reviews(restaurant_id, customer_id, reservation_id, score, content);
        return reviewRepository.save(review);
    }

    @PutMapping(value = "/review/{id}")
    public ResponseEntity updateReview(@PathVariable(value = "id") Long id, @RequestBody Reviews updatedReview) {
        Reviews review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            return ResponseEntity.notFound().build();
        } else {
            review.setRestaurantId(updatedReview.getRestaurantId());
            review.setCustomerId(updatedReview.getCustomerId());
            review.setReservationId(updatedReview.getReservationId());
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