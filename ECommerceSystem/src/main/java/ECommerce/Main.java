package ECommerce;


import ECommerce.Models.Cart;
import ECommerce.Models.Customer;
import ECommerce.Models.ExpirableProduct;
import ECommerce.Models.Product;
import ECommerce.Services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Ali", 3000, "6 October");
        Product tv = new Product("TV", 2500, 30, 1000);
        Product scratchCard = new Product("Scratch Card", 15, 0, 100000);
        ExpirableProduct cheese = new ExpirableProduct("Cheese", 80, 1, 100, 10);

        Cart cart = new Cart();
        cart.addItem(tv, 2);
        cart.addItem(scratchCard, 2);
        cart.addItem(cheese, 2);

        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer);
    }
}
