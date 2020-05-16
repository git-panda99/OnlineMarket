package classes;

import java.util.Objects;

public class Product {
    private String title;
    private String description;
    private int stock;
    private double price;
    private String image;

    public Product(String title, String description, int stock, double price, String image) {
        this.title = title;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getTitle(), product.getTitle());
    }

}
