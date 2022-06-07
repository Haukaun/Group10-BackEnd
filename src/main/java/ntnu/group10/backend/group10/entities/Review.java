package ntnu.group10.backend.group10.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Review Entitiy Class.
 */
@Entity
@Table(name = "review", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "productId"})})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reviewId;

    @ManyToOne
    @JsonIgnoreProperties({ "roles", "id", "password", "email", "active", "valid"})
    @JoinColumn(name = "id", nullable = false)
    private User customer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    private int rating;
    private String description;

    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    @JsonIgnore
    public boolean isValid() {
        return !(description.isBlank() || rating < 0);
    }

    /**
     * Gets review id.
     *
     * @return the review id
     */
    public Integer getReviewId() {
        return reviewId;
    }

    /**
     * Sets review id.
     *
     * @param reviewId the review id
     */
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * Gets customer of the review.
     *
     * @return the customer
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * Sets customer of the review.
     *
     * @param customer the customer
     */
    public void setCustomer(User customer) {
        this.customer = customer;
    }

    /**
     * Gets product for review.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product for review.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Instantiates a new Review.
     */
    public Review() {
    }
}
