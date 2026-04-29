package se.kth.iv1350.repairelectricbike.dto;

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
     * Hämtar kundens telefonnummer.
     *
     * @return telefonnumret
     */
    public String getPhone() {
        return phone;
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