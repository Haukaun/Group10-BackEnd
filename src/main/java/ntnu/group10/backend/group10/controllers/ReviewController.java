package ntnu.group10.backend.group10.controllers;

import ntnu.group10.backend.group10.entities.Review;
import ntnu.group10.backend.group10.services.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {


    @Autowired
    private ReviewService reviewService;

    @GetMapping("/products/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Review>> getAllProductReviewsById(@PathVariable Integer id) {
        ResponseEntity<List<Review>> response;
        try {
            response = new ResponseEntity<>(reviewService.getAllByProductId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addReview(@RequestBody Review review, @PathVariable Integer id) {
        try {
            Review newReview = reviewService.addReview(review, id);
            return new ResponseEntity<>(newReview, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IllegalStateException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteReview(@PathVariable Integer id){
        ResponseEntity<String> response;
        try {
            reviewService.deleteReviewId(id);
            response = new ResponseEntity<>("Review has been deleted.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<Review> editReview(@RequestBody Review review, @PathVariable Integer id) {
        ResponseEntity<Review> response;
        try {
            Review updatedReview = reviewService.editReview(review, id);
            response = new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } catch (NullPointerException e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException exception) {
            response = new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return response;
    }
}
