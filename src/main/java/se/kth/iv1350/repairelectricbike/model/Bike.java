package se.kth.iv1350.repairelectricbike.model;

/**
 * Represents a bike.
 */
public class Bike {
    private String model;
    private String brand;
    private String serialNumber;

    public Bike(String model, String brand, String serialNumber) {
        this.model = model;
        this.brand = brand;
        this.serialNumber = serialNumber;
    }
}