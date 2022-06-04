package ntnu.group10.backend.group10.repository;

import ntnu.group10.backend.group10.entities.Review;
import ntnu.group10.backend.group10.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    //?1 = the first param.
    @Query(value = "select r from Review r where r.product.productId = ?1")
    List<Review> findAllByProductId(int id);

    Optional<Review> findById(int id);
}
