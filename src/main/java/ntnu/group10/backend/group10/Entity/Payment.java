package ntnu.group10.backend.group10.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Payment {
    @Id
    private int paymentId;
    private int paymentMethod;
    private int orderId;
    private int paymentAmount;
    private Date paymentDate;
    private Long creditCardNumber;
    private int creditCardExpirationDate;
    private String cardHolderName;

    public Payment() {
    }
}
