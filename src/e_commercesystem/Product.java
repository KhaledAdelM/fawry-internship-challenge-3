package e_commercesystem;

import java.time.LocalDate;


public class Product {
    private String name;
    private double price;
    private int quantity;

    private boolean isExpirable;
    private LocalDate expiryDate;

    private boolean isShippable;
    private double weight;

    public Product(String name, double price, int quantity, boolean isExpirable, LocalDate expiryDate,
                   boolean isShippable, double weight) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setExpirable(isExpirable);
        setExpiryDate(expiryDate);
        setShippable(isShippable);
        setWeight(weight);
    }

    public boolean isAvailable(int amount) {
        return quantity >= amount;
    }

    public void reduceQuantity(int amount) {
        quantity -= amount;
    }

    public boolean isExpired() {
        return isExpirable && expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) System.out.println("Product name cannot be empty");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) System.out.println("Price cannot be negative");
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) System.out.println("Quantity cannot be negative");
        this.quantity = quantity;
    }

    public boolean isExpirable() {
        return isExpirable;
    }

    public void setExpirable(boolean expirable) {
        this.isExpirable = expirable;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isShippable() {
        return isShippable;
    }

    public void setShippable(boolean shippable) {
        this.isShippable = shippable;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (isShippable && weight < 0) System.out.println("Weight cannot be negative");
        this.weight = weight;
    }
}
