package integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.CustomerDTO;

public class CustomerRegistryHandlerTest {
    private CustomerRegistryHandler customerRegistry;

    @BeforeEach
    public void setUp() {
        customerRegistry = new CustomerRegistryHandler();
    }
    
    

    /** Tests that a existing customer can be found in the registry. */
    @Test
    public void testFindExistingCustomer() {

        CustomerDTO customer = customerRegistry.findCustomer("0701234567");

        assertNotNull(customer);
        assertEquals("0701234567", customer.getPhoneNumber());
        assertEquals("Anton Persson", customer.getName());
        assertEquals(1001, customer.getBikeSerialNumber());
    }

    /** Tests that retrieveing a non existing customer returns true (for alternative flow) */
    @Test
    public void testFindNonExistingCustomer() {

        CustomerDTO customer = customerRegistry.findCustomer("0700000000");

        assertNull(customer);
    }
}
