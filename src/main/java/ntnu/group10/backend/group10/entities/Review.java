package ntnu.group10.backend.group10.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
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

    @JsonIgnore
    public boolean isValid() {
        return !(description.isBlank() || rating < 0);
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Review() {
    }
}
