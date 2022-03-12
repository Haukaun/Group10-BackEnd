package ntnu.group10.backend.group10.Entity;

import javax.persistence.*;

@Entity
@Table(name = "paymentMethod")
public class PaymentMethod {
    @Id
    private int paymentMethodId;
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentId")
    private Payment payment;

    public PaymentMethod() {}

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
