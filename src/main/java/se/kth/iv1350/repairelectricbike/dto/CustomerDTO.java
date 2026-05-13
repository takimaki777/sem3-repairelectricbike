package se.kth.iv1350.repairelectricbike.dto;

import se.kth.iv1350.repairelectricbike.model.Customer;

/**
 * Carries data for a customer.
 */
public class CustomerDTO {
    private String name;
    private String phone;
    private String email;
    private String bikeModel;
    private String bikeBrand;
    private String bikeSerialNumber;

    /**
     * Creates a CustomerDTO from a Customer object.
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
     * Creates a CustomerDTO with specified values.
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

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public String getBikeBrand() {
        return bikeBrand;
    }

    public String getBikeSerialNumber() {
        return bikeSerialNumber;
    }
}