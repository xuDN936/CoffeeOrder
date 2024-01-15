package coffee.management.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import coffee.management.web.data.CoffeeOrder;

/**
 * This class provides a simple client to test the Coffee Order Service and an external REST service.
 */
public class TestCoffeeOrderService {

    private static String webServiceUrl = "http://localhost:8080/coffee.management.web/api/coffee-orders";
    private static String externalRestServiceUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=b2f60904";
    private static String rapidApiKey = "b2f60904";

    /**
     * Main method to run tests on the Coffee Order Service and an external REST service.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Test Creating Coffee Order
        CoffeeOrder espressoOrder = new CoffeeOrder();
        espressoOrder.setCoffeeName("espresso");
        espressoOrder.setPrice(2.5);
        espressoOrder.setQuantity(1);

        createCoffeeOrder(espressoOrder);

        // Test Deleting Coffee Order
        deleteCoffeeOrder(1); // Assuming the order id is 1, replace it with the actual order id

        // Test External REST Service
        testExternalRestService();
    }

    /**
     * Creates a Coffee Order using the Coffee Order Service.
     *
     * @param coffeeOrder The Coffee Order to be created.
     */
    private static void createCoffeeOrder(CoffeeOrder coffeeOrder) {
        System.out.println("Creating Coffee Order...");

        // Print order details
        System.out.println("Coffee Name: " + coffeeOrder.getCoffeeName());
        System.out.println("Price: " + coffeeOrder.getPrice());
        System.out.println("Quantity: " + coffeeOrder.getQuantity());

        WebClient webClient = WebClient.create(webServiceUrl + "/create")
                .type(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE);

        Response response = webClient.post(coffeeOrder);

        System.out.println("HTTP status: " + response.getStatus());

        if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
            System.out.println("Coffee Order created successfully.");
        } else {
            System.out.println("Failed to create Coffee Order. HTTP status: " + response.getStatus());
        }
    }

    /**
     * Deletes a Coffee Order using the Coffee Order Service.
     *
     * @param orderId The ID of the Coffee Order to be deleted.
     */
    private static void deleteCoffeeOrder(int orderId) {
        System.out.println("Deleting Coffee Order...");

        // Print order id being deleted
        System.out.println("Order ID to be deleted: " + orderId);

        WebClient webClient = WebClient.create(webServiceUrl + "/" + orderId);
        webClient.accept(MediaType.APPLICATION_JSON);

        Response response = webClient.delete();

        System.out.println("HTTP status: " + response.getStatus());

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("Coffee Order deleted successfully.");
        } else {
            System.out.println("Failed to delete Coffee Order. HTTP status: " + response.getStatus());
        }
    }

    /**
     * Tests an external REST service using HTTP GET request.
     */
    private static void testExternalRestService() {
        System.out.println("Testing External REST Service...");

        try {
            URL url = new URL(externalRestServiceUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request headers
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-RapidAPI-Key", rapidApiKey);
            connection.setRequestProperty("X-RapidAPI-Host", "community-onehourtranslation.p.rapidapi.com");

            // Send GET request
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                // Print response
                System.out.println("External API Response: " + response.toString());
            } else {
                System.out.println("GET request to External API failed. Response Code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
