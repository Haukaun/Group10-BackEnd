package ntnu.group10.backend.group10.services;

import ntnu.group10.backend.group10.entities.Product;
import ntnu.group10.backend.group10.entities.Review;
import ntnu.group10.backend.group10.entities.User;
import ntnu.group10.backend.group10.repository.ProductRepository;
import ntnu.group10.backend.group10.repository.ReviewRepository;
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


    public void addReview(Review review, Integer productId) {
        Product product = productRepository.findById(productId).orElse(null);
        User currentUser = userService.getCurrentUserDetails();
        if (review.isValid() && product != null && currentUser != null) {
            review.setProduct(product);
            review.setCustomer(currentUser);
            reviewRepository.save(review);
            System.out.println(review.getReviewId());
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


}
