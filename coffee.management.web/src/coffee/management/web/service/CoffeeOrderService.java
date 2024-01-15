package coffee.management.web.service;

import java.util.ArrayList;
import java.util.List;

import coffee.management.web.data.CoffeeOrder;

/**
 * Service class for managing Coffee Orders.
 * This class provides methods for retrieving, creating, and deleting Coffee Orders.
 */
public class CoffeeOrderService {

    // In-memory storage for Coffee Orders
    private static List<CoffeeOrder> coffeeOrders = new ArrayList<>();

    /**
     * Retrieves all Coffee Orders.
     *
     * @return The list of all Coffee Orders.
     */
    public List<CoffeeOrder> getAllCoffeeOrders() {
        return coffeeOrders;
    }

    /**
     * Retrieves a Coffee Order by its ID.
     *
     * @param orderId The ID of the Coffee Order to retrieve.
     * @return The Coffee Order with the specified ID, or null if not found.
     */
    public CoffeeOrder getCoffeeOrderById(int orderId) {
        for (CoffeeOrder order : coffeeOrders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    /**
     * Creates a new Coffee Order.
     *
     * @param coffeeOrder The Coffee Order to be created.
     * @return The created Coffee Order with a unique ID.
     */
    public CoffeeOrder createCoffeeOrder(CoffeeOrder coffeeOrder) {
        int orderId = generateOrderId();
        coffeeOrder.setOrderId(orderId);
        coffeeOrders.add(coffeeOrder);
        return coffeeOrder;
    }

    /**
     * Deletes a Coffee Order by its ID.
     *
     * @param orderId The ID of the Coffee Order to be deleted.
     * @return True if deletion is successful, false if the order is not found.
     */
    public boolean deleteCoffeeOrder(int orderId) {
        CoffeeOrder orderToRemove = null;
        for (CoffeeOrder order : coffeeOrders) {
            if (order.getOrderId() == orderId) {
                orderToRemove = order;
                break;
            }
        }

        if (orderToRemove != null) {
            coffeeOrders.remove(orderToRemove);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Generates a new unique ID for a Coffee Order.
     *
     * @return The new unique ID.
     */
    private int generateOrderId() {
        // Your logic to generate a unique order ID
        // For simplicity, we'll just use the current size of the list + 1
        return coffeeOrders.size() + 1;
    }
}
