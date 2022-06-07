package ntnu.group10.backend.group10.repository;

import ntnu.group10.backend.group10.entities.Product;
import ntnu.group10.backend.group10.entities.Review;
import ntnu.group10.backend.group10.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Review repository.
 * JpaRepository is a JPA specific extension.
 * Full API of CrudRepository.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    /**
     * Find all reviews by product id.
     *
     * @param id, review id
     * @return the list of review
     */
//?1 = the first param.
    @Query(value = "select r from Review r where r.product.productId = ?1")
    List<Review> findAllByProductId(int id);

    /**
     * Find review by id.
     *
     * @param id, review id.
     * @return optional review.
     */
    Optional<Review> findById(int id);

    /**
     * Find by customer and product that matches the parameter.
     *
     * @param customer, User entity.
     * @param product, Product entity.
     * @return optional review.
     */
    Optional<Review> findByCustomerAndProductEquals(User customer, Product product);
}
