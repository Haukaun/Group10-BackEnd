package ntnu.group10.backend.group10.entities;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    private int orderId;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @OneToOne(mappedBy = "order")
    @PrimaryKeyJoinColumn
    private Payment payment;

    public Order(int orderId, User user) {
        this.orderId = orderId;
        this.user = user;
    }

    public Order() {
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getCustomer() {
        return user;
    }

    public void setCustomer(User user) {
        this.user = user;
    }
}
