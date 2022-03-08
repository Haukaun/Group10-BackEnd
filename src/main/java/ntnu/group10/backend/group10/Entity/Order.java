package ntnu.group10.backend.group10.Entity;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    private int orderId;
    private int customerId;


    @OneToOne
    private Payment payment;


    public Order() {
    }

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
