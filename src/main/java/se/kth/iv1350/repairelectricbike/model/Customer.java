package se.kth.iv1350.repairelectricbike.model;

/**
 * Represents a customer.
 */
public class Customer {
    private String name;
    private String phone;
    private String email;
    private String bikeModel;
    private String bikeBrand;
    private String bikeSerialNumber;

    /**
     * Creates a new customer.
     *
     * @param name The customer's name.
     * @param phone The customer's phone number.
     * @param email The customer's email.
     * @param bikeModel The bike model.
     * @param bikeBrand The bike brand.
     * @param bikeSerialNumber The bike serial number.
     */
    public Customer(String name, String phone, String email,
                    String bikeModel, String bikeBrand, String bikeSerialNumber) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bikeModel = bikeModel;
        this.bikeBrand = bikeBrand;
        this.bikeSerialNumber = bikeSerialNumber;
    }

    /**
     * Gets the customer's name.
     *
     * @return The customer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the customer's phone number.
     *
     * @return The customer's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the customer's email.
     *
     * @return The customer's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the bike model.
     *
     * @return The bike model.
     */
    public String getBikeModel() {
        return bikeModel;
    }

    /**
     * Gets the bike brand.
     *
     * @return The bike brand.
     */
    public String getBikeBrand() {
        return bikeBrand;
    }

    /**
     * Gets the bike serial number.
     *
     * @return The bike serial number.
     */
    public String getBikeSerialNumber() {
        return bikeSerialNumber;
    }
}