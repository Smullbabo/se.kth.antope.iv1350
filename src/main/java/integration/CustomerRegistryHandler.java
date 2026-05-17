package integration;

import dto.CustomerDTO;
import exceptions.CustomerNotFoundException;
import exceptions.DatabaseFailException;

import java.util.HashMap;
import java.util.Map;

/** Simulates the class contacting a customer registry. */
public class CustomerRegistryHandler {
    private final Map<String, CustomerDTO> customersByPhone = new HashMap<>();

    private static final String DATABASE_FALIURE_PHONE = "0000000000";

    /** Creates the registry handler and fills it with sample customer data. */
    public CustomerRegistryHandler() {
        addSampleCustomers();
    }

    /** Finds a customer by phone number.
     * 
     * @param phoneNumber CUstomer phone number
     * @return DTO of a customer from simulated database.
     * @throws CustomerNotFoundException if no customer with provided phone number exists in map.
     * @throws DatabaseFailException if the simulated database cannot be reached.
     */
    public CustomerDTO findCustomer(String phoneNumber) throws CustomerNotFoundException{

        if (DATABASE_FALIURE_PHONE.equals(phoneNumber)) {
        throw new DatabaseFailException(
                "Could not contact customer database when searching for phone number: " + phoneNumber
        );
    }
        
        CustomerDTO customer = customersByPhone.get(phoneNumber);

        if(customer == null) {
            throw new CustomerNotFoundException(phoneNumber);
        }
        
        return customer;
    }

    private void addSampleCustomers() {
        customersByPhone.put("0701234567", new CustomerDTO("Anton Persson", "anton@example.com", "0701234567","VoltBike", "VoltBike City", 1001));
        customersByPhone.put("0707654321", new CustomerDTO("Erik Eriksson", "erik@example.com", "0707654321","E-Rider", "E-Rider Pro", 2002));
    }
}
