package ntnu.group10.backend.group10.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    private int paymentId;

    @OneToOne
    @JoinColumn(name = "orderId", nullable = false)
    private int order;

    @OneToMany
    @JoinColumn(name = "paymentMethodId", nullable = false)
    private int paymentMethod;

    private int paymentAmount;
    private Date paymentDate;
    private Long creditCardNumber;
    private int creditCardExpirationDate;
    private String cardHolderName;

    public Payment(int paymentId, int order, int paymentMethod, int paymentAmount, Date paymentDate, Long creditCardNumber, int creditCardExpirationDate, String cardHolderName) {
        this.paymentId = paymentId;
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpirationDate = creditCardExpirationDate;
        this.cardHolderName = cardHolderName;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getOrderId() {
        return order;
    }

    public void setOrderId(int order) {
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
