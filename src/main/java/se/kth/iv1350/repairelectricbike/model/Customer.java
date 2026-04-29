package se.kth.iv1350.repairelectricbike.model;

/**
 * Representerar en kund.
 */
public class Customer {
    private String name;
    private String phone;
    private String email;

    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
}