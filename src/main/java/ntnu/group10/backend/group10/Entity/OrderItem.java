package ntnu.group10.backend.group10.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
    @Id
    private int orderItemId;

    @OneToOne
    private Order order;
    private int productId;
    private int quantity;

    public OrderItem() {
    }
}
