package dto;

/** DTO transfering customer data between layers. (Cannot be modified after creation) */
public class CustomerDTO {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String bikeBrand;
    private final String bikeModel;
    private final int bikeSerialNumber;

    /** Creates a DTO containing the visible customer information.
     * 
     * @param name Customer name
     * @param email Customer email adress
     * @param phoneNumber Customer phone number
     * @param bikeBrand Brand of the curstomers bike
     * @param bikeModel Model of the customers bike
     * @param bikeSerialNumber Serialnumber found on the customers bike
    */
    public CustomerDTO(String name, String email, String phoneNumber, String bikeBrand, String bikeModel, int bikeSerialNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bikeBrand = bikeBrand;
        this.bikeModel = bikeModel;
        this.bikeSerialNumber = bikeSerialNumber;
    }

    /** Gets the customers name. */
    public String getName() { return name; }

    /** Gets the customers email address. */
    public String getEmail() { return email; }

    /** Gets the customers phone number. */
    public String getPhoneNumber() { return phoneNumber; }

    /** Gets the customers bike brand. */
    public String getBikeBrand() { return bikeBrand; }

    /** Gets the customers bike model. */
    public String getBikeModel() { return bikeModel; }

    /** Gets the customers bike serial number. */
    public int getBikeSerialNumber() { return bikeSerialNumber; }

   
}
