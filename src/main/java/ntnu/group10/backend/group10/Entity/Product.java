package ntnu.group10.backend.group10.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int productId;
    private int orderItemId;
    private String productName;

    public Product() {
    }
}
