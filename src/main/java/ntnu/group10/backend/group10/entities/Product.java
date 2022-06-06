package ntnu.group10.backend.group10.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Product.
 */
@Entity
public class Product {
    @Id
    private int productId;
    private String productName;
    private String description;
    private int basePrice;
    private int groupPrice;

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets base price.
     *
     * @return the base price
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * Sets base price.
     *
     * @param basePrice the base price
     */
    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Gets group price.
     *
     * @return the group price
     */
    public int getGroupPrice() {
        return groupPrice;
    }

    /**
     * Sets group price.
     *
     * @param discountedPrice the discounted price
     */
    public void setGroupPrice(int discountedPrice) {
        this.groupPrice = discountedPrice;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets product id.
     *
     * @param productId the product id
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Gets product name.
     *
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets product name.
     *
     * @param productName the product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }
}
