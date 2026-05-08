package se.kth.iv1350.repairelectricbike.dto;

import se.kth.iv1350.repairelectricbike.model.Customer;

/**
 * The class carries customer data.
 */
public class CustomerDTO {
    private String name;
    private String phone;
    private String email;
    private String bikeModel;
    private String bikeBrand;
    private String bikeSerialNumber;

    /**
     * Creates a new CustomerDTO.
     *
     * @param name The customer's name.
     * @param phone The customer's phone number.
     * @param email The customer's email address.
     * @param bikeModel The model of the bike.
     * @param bikeBrand The brand of the bike.
     * @param bikeSerialNumber The serial number of the bike.
     */
    public CustomerDTO(String name, String phone, String email,
                       String bikeModel, String bikeBrand, String bikeSerialNumber) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bikeModel = bikeModel;
        this.bikeBrand = bikeBrand;
        this.bikeSerialNumber = bikeSerialNumber;
    }

    /**
     * Creates a DTO from a Customer object.
     *
     * @param customer The customer whose data will be copied.
     */
    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.bikeModel = customer.getBikeModel();
        this.bikeBrand = customer.getBikeBrand();
        this.bikeSerialNumber = customer.getBikeSerialNumber();
    }

    /**
     * Returns the customer's phone number.
     *
     * @return The customer's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the customer's name.
     *
     * @return The customer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the customer's email address.
     *
     * @return The customer's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the bike model.
     *
     * @return The bike model.
     */
    public String getBikeModel() {
        return bikeModel;
    }

    /**
     * Returns the bike brand.
     *
     * @return The bike brand.
     */
    public String getBikeBrand() {
        return bikeBrand;
    }

    /**
     * Returns the bike serial number.
     *
     * @return The bike serial number.
     */
    public String getBikeSerialNumber() {
        return bikeSerialNumber;
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return A string containing customer information.
     */
    @Override
    public String toString() {
        return "Customer: " + name +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Bike brand: " + bikeBrand +
                ", Bike model: " + bikeModel +
                ", Bike serial number: " + bikeSerialNumber;
    }
}