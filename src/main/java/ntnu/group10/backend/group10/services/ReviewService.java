package ntnu.group10.backend.group10.services;

import ntnu.group10.backend.group10.entities.Product;
import ntnu.group10.backend.group10.entities.Review;
import ntnu.group10.backend.group10.entities.User;
import ntnu.group10.backend.group10.repository.ProductRepository;
import ntnu.group10.backend.group10.repository.ReviewRepository;
import org.hibernate.DuplicateMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Review service. Service class which handles CRUD logic for reviews.
 */
@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    /**
     * Get all reviews.
     *
     * @return all reviews
     */
    public List<Review> getAll() {
        return reviewRepository.findAll();

    }

    /**
     * Gets all reviews by defined product id.
     *
     * @param id of the product
     * @return all reviews by product id
     */
    public List<Review> getAllByProductId(int id) {
        return reviewRepository.findAllByProductId(id);
    }


    /**
     * Add a review. Checks if it already exists and checks if the review is valid.
     * Saves it with the help of Spring Repository Class.
     *
     * @param review, Entity class for review.
     * @param productId, id of product.
     * @return the review
     */
    public Review addReview(Review review, Integer productId) {
        Product product = productRepository.findById(productId).orElse(null);
        User currentUser = userService.getCurrentUserDetails();
        if (reviewRepository.findByCustomerAndProductEquals(currentUser, product).isPresent()) {
            throw new IllegalStateException("You already have a review for this product.");
        }
        if (review.isValid() && product != null && currentUser != null) {
            review.setProduct(product);
            review.setCustomer(currentUser);
            return reviewRepository.save(review);
        } else {
            throw new IllegalArgumentException("Review not valid");
        }
    }

    /**
     * Deletes reviews based on review id.
     * Checks if the review is present and deletes review.
     *
     * @param id, id for review.
     */
    public void deleteReviewId(Integer id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review foundReview = reviewOptional.get();
            reviewRepository.delete(foundReview);
        }
    }

    /**
     * Edit review. Gets old review and updates it to a new edited review.
     *
     * @param review, Entity class for review.
     * @param id, id for review.
     * @return the newly edited review
     */
    public Review editReview(Review review, Integer id) {
        Review oldReview = reviewRepository.findById(id).orElse(null);
        if (oldReview != null) {
            oldReview.setRating(review.getRating());
            oldReview.setDescription(review.getDescription());
            return reviewRepository.save(oldReview);
        } else {
            throw new IllegalArgumentException("Ops");
        }
    }


}
