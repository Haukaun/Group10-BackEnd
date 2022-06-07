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

/**
 * The type Review controller. Controller class is responsible for processing incoming
 * REST API requests, preparing model, and return response.
 */
@Controller
@RequestMapping("/review")
public class ReviewController {


    @Autowired
    private ReviewService reviewService;


    /**
     * GET method for getting all reviews based on productId.
     * It tries to receive all users, if not it is logged and exception thrown.
     * OK Status 200, if all of the reviews is given.
     * Bad request 400, If reviews is not received.
     * @param id, id for product.
     * @return all reviews by product id
     */
    @GetMapping("/products/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Review>> getAllProductReviewsById(@PathVariable Integer id) {
        ResponseEntity<List<Review>> response;
        try {
            response = new ResponseEntity<>(reviewService.getAllByProductId(id), HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    /**
     * Post method for Adding review.
     * Sends response based on it being add or not. Only for Admins and Customers.
     * Created 201, if review is successfully added.
     * Conflict 409, if there already exist a review form that user.
     * Bad request 400, if input .
     *
     * @param review the review
     * @param id     the id
     * @return the response entity, CREATED, BAD_REQUEST or CONFLICT
     */
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

    /**
     * Delete method for deleting review.
     * Sends OK if deleted or Bad Request if not deleted.
     * This method is permitted only for User with Admin role.
     *  Ok 200, If review is deleted.
     *  BAD_REQUEST, if it is null or something is wrong.
     * @param id, product id
     * @return the response entity, BAD_REQUEST or OK
     */
    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteReview(@PathVariable Integer id){
        ResponseEntity<String> response;
        try {
            reviewService.deleteReviewId(id);
            response = new ResponseEntity<>("Review has been deleted.",HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    /**
     * Patch method for updating review.
     * Sends repsonse based successful update, if not is not found or if User is unauthorized.
     * OK 200, If review is updated correctly.
     * NOT_FOUND 404, if review does not exist.
     * UNAUTHORIZED 401, if the user is not accessed.
     * @param review, Review entitiy.
     * @param id, id of review
     * @return the response entity.
     */
    @PatchMapping("/products/{id}")
    public ResponseEntity<Review> editReview(@RequestBody Review review, @PathVariable Integer id) {
        ResponseEntity<Review> response;
        try {
            Review updatedReview = reviewService.editReview(review, id);
            response = new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } catch (NullPointerException e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException exception) {
            response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return response;
    }
}
