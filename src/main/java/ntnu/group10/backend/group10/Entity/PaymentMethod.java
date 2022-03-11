package ntnu.group10.backend.group10.Entity;

import javax.persistence.*;

@Entity
public class PaymentMethod {
    @Id
    private int paymentMethodId;
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentId")
    private Payment payment;


    public PaymentMethod() {
    }
}
