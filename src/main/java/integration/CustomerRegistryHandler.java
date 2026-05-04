package integration;

import dto.CustomerDTO;
import java.util.HashMap;
import java.util.Map;

/** Simulates the class contacting a customer registry. */
public class CustomerRegistryHandler {
    private final Map<String, CustomerDTO> customersByPhone = new HashMap<>();

    /** Creates the registry handler and fills it with sample customer data. */
    public CustomerRegistryHandler() {
        addSampleCustomers();
    }

    /** Finds a customer by phone number.
     * 
     * @param phoneNumber CUstomer phone number
     * @return DTO of a customer from simulated database.
     */
    public CustomerDTO findCustomer(String phoneNumber) {
        return customersByPhone.get(phoneNumber);
    }

    private void addSampleCustomers() {
        customersByPhone.put("0701234567", new CustomerDTO("Anton Persson", "anton@example.com", "0701234567","VoltBike", "VoltBike City", 1001));
        customersByPhone.put("0707654321", new CustomerDTO("Erik Eriksson", "erik@example.com", "0707654321","E-Rider", "E-Rider Pro", 2002));
    }
}
