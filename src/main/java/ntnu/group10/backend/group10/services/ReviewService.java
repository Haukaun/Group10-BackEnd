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

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    public List<Review> getAll() {
        return reviewRepository.findAll();

    }

    public List<Review> getAllByProductId(int id) {
        return reviewRepository.findAllByProductId(id);
    }


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

    public void deleteReviewId(Integer id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review foundReview = reviewOptional.get();
            reviewRepository.delete(foundReview);
        }
    }

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
