package ntnu.group10.backend.group10.repository;

import ntnu.group10.backend.group10.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface product repository.
 * JpaRepository is a JPA specific extension.
 * Full API of CrudRepository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
