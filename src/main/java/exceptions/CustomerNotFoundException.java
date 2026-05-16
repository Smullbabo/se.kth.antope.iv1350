package exceptions;

public class CustomerNotFoundException extends Exception{
    private final String phoneNumber;

    public CustomerNotFoundException(String phoneNumber) {

        super("No customer with phone number: " + phoneNumber);

        this.phoneNumber = phoneNumber;
    }
}
