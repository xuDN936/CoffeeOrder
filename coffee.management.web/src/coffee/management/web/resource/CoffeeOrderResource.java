package coffee.management.web.resource;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import coffee.management.web.data.CoffeeOrder;

/**
 * Resource class for managing Coffee Orders through RESTful web services.
 * This class provides endpoints for retrieving, creating, and deleting Coffee Orders.
 */
@Path("/coffee-orders")
public class CoffeeOrderResource {

    // In-memory storage for Coffee Orders
    private static Map<Integer, CoffeeOrder> ORDER_DATA = new HashMap<>();

    /**
     * Retrieves a Coffee Order by its ID.
     *
     * @param orderId The ID of the Coffee Order to retrieve.
     * @return Response containing the requested Coffee Order in JSON format, or a 404 Not Found response if the order is not found.
     */
    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoffeeOrder(@PathParam("orderId") int orderId) {
        CoffeeOrder coffeeOrder = ORDER_DATA.get(orderId);
        if (coffeeOrder != null) {
            return Response.ok(coffeeOrder).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Creates a new Coffee Order.
     *
     * @param coffeeOrder The Coffee Order to be created, provided in JSON format.
     * @return Response containing the created Coffee Order in JSON format and a 201 Created status, or an error response if creation fails.
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCoffeeOrder(CoffeeOrder coffeeOrder) {
        int orderId = getNewOrderId();
        coffeeOrder.setOrderId(orderId);
        ORDER_DATA.put(orderId, coffeeOrder);
        return Response.status(Response.Status.CREATED).entity(coffeeOrder).build();
    }

    /**
     * Deletes a Coffee Order by its ID.
     *
     * @param orderId The ID of the Coffee Order to be deleted.
     * @return Response with a 200 OK status if deletion is successful, or a 404 Not Found response if the order is not found.
     */
    @DELETE
    @Path("/{orderId}")
    public Response deleteCoffeeOrder(@PathParam("orderId") int orderId) {
        CoffeeOrder coffeeOrder = ORDER_DATA.get(orderId);
        if (coffeeOrder != null) {
            ORDER_DATA.remove(orderId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Generates a new unique ID for a Coffee Order.
     *
     * @return The new unique ID.
     */
    private int getNewOrderId() {
        int newId = 0;
        for (int id : ORDER_DATA.keySet()) {
            if (newId < id)
                newId = id;
        }
        return ++newId;
    }
}
