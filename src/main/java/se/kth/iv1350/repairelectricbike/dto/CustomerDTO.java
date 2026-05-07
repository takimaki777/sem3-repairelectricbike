package se.kth.iv1350.repairelectricbike.dto;
import se.kth.iv1350.repairelectricbike.model.Customer;

/**
 * Klassen bär kunddata.
 */
public class CustomerDTO {
    private String name;
    private String phone;
    private String email;
    private String bikeModel;
    private String bikeBrand;
    private String bikeSerialNumber;

    /**
     * Skapar en ny CustomerDTO.
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
     * Creates a DTO from a customer object.
     *
     * @param customer The customer to copy data from.
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
     * Hämtar kundens telefonnummer.
     *
     * @return telefonnumret
     */
    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
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

    /**
     * Returnerar en strängrepresentation av kunden.
     */
    public String toString() {
        return "Customer: " + name +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Bike brand: " + bikeBrand +
                ", Bike model: " + bikeModel +
                ", Bike serial number: " + bikeSerialNumber;
    }

}