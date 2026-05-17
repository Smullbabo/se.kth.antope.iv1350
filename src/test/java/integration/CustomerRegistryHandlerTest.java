package integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.CustomerDTO;
import exceptions.CustomerNotFoundException;
import exceptions.DatabaseFailException;

public class CustomerRegistryHandlerTest {
    private CustomerRegistryHandler customerRegistry;

    @BeforeEach
    public void setUp() {
        customerRegistry = new CustomerRegistryHandler();
    }
    
    

    /** Tests that a existing customer can be found in the registry. */
    @Test
    public void testFindExistingCustomer() throws CustomerNotFoundException{

        CustomerDTO customer = customerRegistry.findCustomer("0701234567");

        assertNotNull(customer,"Customer = null not expected");
        assertEquals("0701234567", customer.getPhoneNumber(),"Did not match expected value ");
        assertEquals("Anton Persson", customer.getName(),"Did not match expected value ");
        assertEquals(1001, customer.getBikeSerialNumber(),"Did not match expected value ");
    }

    /** Tests that retrieveing a non existing customer returns true (for alternative flow) */
    @Test
    public void testFindNonExistingCustomer() {

      assertThrows(CustomerNotFoundException.class, () -> customerRegistry.findCustomer("0700000000"), "Searching for nonexisting customer should throw CustomerNotFOundException");
    }

    @Test
    public void testFindCustomerDatabaseFail() {
        
        assertThrows(DatabaseFailException.class, () -> customerRegistry.findCustomer("0000000000"), "Searching for the hardcoded database fail phone number should throw a DatabaseFailException!");
    }
}
