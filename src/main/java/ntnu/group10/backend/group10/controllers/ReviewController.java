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

    Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @GetMapping("/products/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Review>> getAllProductReviewsById(@PathVariable Integer id) {
        ResponseEntity<List<Review>> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {
            response = new ResponseEntity<>(reviewService.getAllByProductId(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return response;
        }
        return response;
    }

    @PostMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> addReview(@RequestBody Review review, @PathVariable Integer id) {
        ResponseEntity<String> response;
        try {
            reviewService.addReview(review, id);
            response = new ResponseEntity<>("Review has been created.",HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return response;
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteReview(@RequestBody Review review, @PathVariable Integer id){
        ResponseEntity<String> response;
        try {
            reviewService.deleteReviewId(review);
            response = new ResponseEntity<>("Review has been deleted.",HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return response;
    }


}
