package ntnu.group10.backend.group10.Entity;

import javax.persistence.*;

@Entity
public class PaymentMethod {
    @Id
    private int paymentMethodId;

    @ManyToOne
    @JoinColumn(name = "PaymentMethodId",nullable = false)
    private PaymentMethod paymentMethod;

    public PaymentMethod() {
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
