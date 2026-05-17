package exceptions;

/** Exception thrown when a customers phone number does not match any customer in the customer database.
 * 
*/
public class CustomerNotFoundException extends Exception{


    /** Creates new exception for a fail customer search.
     * 
     * @param phoneNumber The phone number not connected to any customer.
     */
    public CustomerNotFoundException(String phoneNumber) {

        super("No customer exists with phone number: " + phoneNumber);
    }
}
