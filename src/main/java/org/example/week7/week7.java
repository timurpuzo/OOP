package org.example.week7;

import java.util.List;

public class week7 {
    public static void main(String[] args) {

    }
    public static double calculateTotalDiscountedPrice(List<Product> products,DiscountStrategy discount){
        double total = 0.0;
        for(Product p : products){
            total += discount.applyDiscount(p.getPrice(), p.getQuantity());
        }
        return total;
    }

    public static double calculateOriginalTotalPrice(List<Product> products){
        double total = 0.0;

        for(Product p : products){
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }
}

class Product{
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}

class PercentageDiscount implements DiscountStrategy{
    public double applyDiscount(double price, int quantity){
        return price * 0.9;
    }
}

class FixedDiscount implements DiscountStrategy{
    public double applyDiscount(double price, int quantity){
        return price - 50.0;
    }
}

class BulkDiscount implements DiscountStrategy{
    public double applyDiscount(double price, int quantity){
        return quantity > 3 ? price * 0.80 : price;
    }
}

