package ntnu.group10.backend.group10.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItem {
    @Id
    private int orderItemId;
    private int orderId;
    private int productId;
    private int quantity;

    public OrderItem() {
    }
}
