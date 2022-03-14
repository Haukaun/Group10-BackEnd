package ntnu.group10.backend.group10.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Payment {

    @Id
    private int orderId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "orderId")
    private Order order;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payment")
    private Set<PaymentMethod> paymentMethods;

    private int paymentAmount;
    private Date paymentDate;
    private Long creditCardNumber;
    private int creditCardExpirationDate;
    private String cardHolderName;

    public Payment(int paymentId, Order order, Set<PaymentMethod> paymentMethods, int paymentAmount, Date paymentDate, Long creditCardNumber, int creditCardExpirationDate, String cardHolderName) {
        this.orderId = paymentId;
        this.order = order;
        this.paymentMethods = paymentMethods;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpirationDate = creditCardExpirationDate;
        this.cardHolderName = cardHolderName;
    }

    public Payment() {}


    public int getPaymentId() {
        return orderId;
    }

    public void setPaymentId(int paymentId) {
        this.orderId = paymentId;
    }

    public Set<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Set<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Order getOrderId() {
        return order;
    }

    public void setOrderId(Order order) {
        this.order = order;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    public void setCreditCardExpirationDate(int creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
