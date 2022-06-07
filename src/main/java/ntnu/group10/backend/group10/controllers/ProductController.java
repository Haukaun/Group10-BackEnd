package ntnu.group10.backend.group10.controllers;

import ntnu.group10.backend.group10.entities.Product;
import ntnu.group10.backend.group10.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

/**
 * The type Product controller. Controller class is responsible for processing incoming
 * REST API requests, preparing model, and return response.
 */
@Controller
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Sends OK 200, if the products are loaded correctly.
     * @return the all products
     */
    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    /**
     * Send repsonses based on the product existing or not.
     * OK 200, If the product exists and received.
     * BAD_REQUEST 400, if the product does not exist.
     * @param productId, id of product.
     * @return the product by id
     */
    @PreAuthorize("permitAll()")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer productId){
        Optional<Product> optionalProduct = productService.getProductById(productId);
        if (optionalProduct.isPresent()){
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
