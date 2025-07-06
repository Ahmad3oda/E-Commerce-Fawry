package ECommerce;


import ECommerce.Models.*;
import ECommerce.Services.CheckoutService;
import ECommerce.Services.ShippingService;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Ali", 10000, "6 October");
        Product tv = new Product("TV", 2500, 30, 1000);
        Product scratchCard = new Product("Scratch Card", 15, 0, 100000);
        ExpirableProduct cheese = new ExpirableProduct("Cheese", 80, 1, 100, 10);

        Cart cart = new Cart();
        cart.addItem(tv, 2);
        cart.addItem(scratchCard, 2);
        cart.addItem(cheese, 2);

        ArrayList<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            System.out.println(item.getProduct().getName() + " " + item.getQuantity());
        }

        System.out.println(cart.isEmpty());
        customer.setCart(cart);
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer);

        ShippingService shippingService = new ShippingService();
        shippingService.ship(checkoutService.getShippableItems());
        
    }
}
