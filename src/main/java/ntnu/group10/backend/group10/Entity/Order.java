package ntnu.group10.backend.group10.Entity;

import javax.persistence.*;

@Entity
@Table(name="´Order´")
public class Order {

    @Id
    private int orderId;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne(mappedBy = "order")
    @PrimaryKeyJoinColumn
    private Payment payment;

    public Order(int orderId, Customer customerId) {
        this.orderId = orderId;
        this.customer = customerId;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
