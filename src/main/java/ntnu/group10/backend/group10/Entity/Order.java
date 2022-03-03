package ntnu.group10.backend.group10.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

    @Id
    private int orderId;
    private int customerId;

    public Order() {
    }
}
