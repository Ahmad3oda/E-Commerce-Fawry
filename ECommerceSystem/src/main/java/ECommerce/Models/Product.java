package ECommerce.Models;

import ECommerce.Interfaces.Shippable;

public class Product implements Shippable {
    protected String name;
    protected double price;
    protected double weight;
    protected int quantity;

    public Product(String name, double price, double weight, int quantity) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public boolean isShippable (){
        return weight > 0;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
