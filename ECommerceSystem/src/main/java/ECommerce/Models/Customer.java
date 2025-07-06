package ECommerce.Models;

public class Customer {
    private String name;
    private double balance;
    private String address;
    private Cart cart = new Cart();

    public Customer(String name, double balance, String address, Cart cart) {
        this.name = name;
        this.balance = balance;
        this.address = address;
        this.cart = cart;
    }

    public Customer(String name, double balance, String address) {
        this.name = name;
        this.balance = balance;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
