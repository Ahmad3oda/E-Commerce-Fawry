package ECommerce.Services;

import ECommerce.Interfaces.CheckoutServiceInterface;
import ECommerce.Interfaces.Shippable;
import ECommerce.Models.CartItem;
import ECommerce.Models.Customer;
import ECommerce.Models.ExpirableProduct;
import ECommerce.Models.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class CheckoutService implements CheckoutServiceInterface {

    @Override
    public void checkout(Customer customer){
        if(customer.getCart().isEmpty()){
            throw new IllegalStateException("Cart is empty");
        }

        ArrayList<CartItem> cartList = customer.getCart().getCartItems();
        ArrayList<Shippable> shippableItems = new ArrayList<>();
        double itemsPrice = customer.getCart().getTotalPrice();
        double itemsTotalWeight = 0;


        for(CartItem item : cartList){

            // validate product.
            Product product = getProduct(item);

            // shippable?
            if(product.isShippable()){
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add(product);
                    itemsTotalWeight += product.getWeight();
                }
            }
        }

        double kgPrice = 30;
        double shippingFees = itemsTotalWeight * kgPrice;
        double totalPrice = itemsTotalWeight + shippingFees;

        if(customer.getBalance() < totalPrice){
            throw new IllegalStateException("Insufficient balance.");
        }

        for(CartItem item : cartList){
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }

        customer.setBalance(customer.getBalance() - totalPrice);

        if(!shippableItems.isEmpty()){

        }

        // receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cartList) {
            System.out.printf("%dx %s %.0f%n", item.getQuantity(), item.getProduct().getName(),
                    item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", itemsPrice);
        System.out.printf("Shipping %.0f%n", shippingFees);
        System.out.printf("Amount %.0f%n", totalPrice);
        System.out.printf("Remaining Balance %.0f%n", customer.getBalance());

        customer.getCart().clear();
    }

    private static Product getProduct(CartItem item) {
        Product product = item.getProduct();
        // check expiry date.
        if(product instanceof ExpirableProduct){
            if(((ExpirableProduct) product).isExpired()){
                throw new IllegalArgumentException( product.getName() + " is expired");
            }
        }

        // check quantity again.
        if(item.getQuantity() > product.getQuantity()){
            throw new IllegalArgumentException(product + " is out of stock.");
        }
        return product;
    }
}
