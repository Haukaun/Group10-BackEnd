package ntnu.group10.backend.group10.services;

import ntnu.group10.backend.group10.entities.Review;
import ntnu.group10.backend.group10.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;


    public List<Review> getAll() {
        return reviewRepository.findAll();

    }

    public List<Review> getAllByProductId(int id) {
        return reviewRepository.findAllByProductId(id);

    }


    public void addReview(Review review) {
        if (review.isValid()) {
            reviewRepository.save(review);
        } else {
            throw new IllegalArgumentException("Review already exists.");
        }
    }

    public void deleteReviewId(Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(review.getReviewId());
        if (reviewOptional.isPresent()) {
            Review foundReview = reviewOptional.get();
            reviewRepository.delete(foundReview);
        }
    }


}
