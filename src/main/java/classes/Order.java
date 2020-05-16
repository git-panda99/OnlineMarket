package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private String name;
    private double price;
    private int quantity;
    private String farmerName;
    private String date;

    public Order(String name, double price, int quantity, String farmerName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.farmerName = farmerName;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'at' HH:mm:ss");
        date=myDateObj.format(formatter);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public String getDate() {
        return date;
    }
}
