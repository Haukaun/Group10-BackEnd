package ntnu.group10.backend.group10.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
    private int reviewId;
    private int customerId;
    private int productId;
    private int star;
    private String description;
    private int likeRatio;

    public Review() {
    }
}
