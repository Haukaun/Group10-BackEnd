package ntnu.group10.backend.group10.entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    private int star;
    private String reviewTitle;
    private String description;

    public boolean isValid() {
        return !(reviewTitle.isBlank() && description.isBlank() && star < 0);
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
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
