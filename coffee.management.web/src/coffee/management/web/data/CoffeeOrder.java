package coffee.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a Coffee Order entity.
 * This class is annotated with {@link XmlRootElement} to support JAXB.
 */
@XmlRootElement
public class CoffeeOrder {
    private int orderId;
    private String coffeeName;
    private double price;
    private int quantity;

    /**
     * Default constructor required for JAXB.
     */
    public CoffeeOrder() {
        // Default constructor required for JAXB
    }

    /**
     * Creates a Coffee Order with specified attributes.
     *
     * @param orderId    The unique identifier for the order.
     * @param coffeeName The name of the coffee.
     * @param price      The price of the coffee.
     * @param quantity   The quantity of coffee in the order.
     */
    public CoffeeOrder(int orderId, String coffeeName, double price, int quantity) {
        this.orderId = orderId;
        this.coffeeName = coffeeName;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Creates a Coffee Order with specified attributes.
     *
     * @param coffeeName The name of the coffee.
     * @param price      The price of the coffee.
     * @param quantity   The quantity of coffee in the order.
     */
    public CoffeeOrder(String coffeeName, double price, int quantity) {
        this.coffeeName = coffeeName;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the order ID.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the order ID.
     *
     * @param orderId The order ID to set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the name of the coffee.
     *
     * @return The name of the coffee.
     */
    public String getCoffeeName() {
        return coffeeName;
    }

    /**
     * Sets the name of the coffee.
     *
     * @param coffeeName The name of the coffee to set.
     */
    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    /**
     * Gets the price of the coffee.
     *
     * @return The price of the coffee.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the coffee.
     *
     * @param price The price of the coffee to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the quantity of coffee in the order.
     *
     * @return The quantity of coffee.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of coffee in the order.
     *
     * @param quantity The quantity of coffee to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the Coffee Order.
     *
     * @return A string representation of the Coffee Order.
     */
    @Override
    public String toString() {
        return "CoffeeOrder{" +
                "orderId=" + orderId +
                ", coffeeName='" + coffeeName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
