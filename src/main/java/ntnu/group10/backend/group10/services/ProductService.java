package ntnu.group10.backend.group10.services;

import ntnu.group10.backend.group10.entities.Product;
import ntnu.group10.backend.group10.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * The type Product service. Service class which handles CRUD logic for product.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Gets all products.
     *
     * @return all products
     */
    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Finds product by id.
     *
     * @param id, id for product
     * @return product by id
     */
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }
}
