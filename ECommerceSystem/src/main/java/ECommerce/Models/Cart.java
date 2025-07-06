package ECommerce.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Cart {
    protected ArrayList<CartItem> cartItems;
    private int totalPrice;

    public Cart() {
        this.cartItems = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addItem (Product product, int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if(product.getQuantity() < quantity){
            throw new IllegalArgumentException("No enough items from this product");
        }
        if(product instanceof ExpirableProduct){
            if(((ExpirableProduct) product).isExpired()){
                throw new IllegalArgumentException("This product is expired");
            }
        }

        // already added items need to be handled.
        for (CartItem item : cartItems) {
            if(item.getProduct() == product){
                int newQuantity = item.getQuantity() + quantity;
                if(product.getQuantity() < newQuantity){
                    throw new IllegalArgumentException("No enough items from this product");
                }
                totalPrice -= item.getQuantity() * product.getPrice();
                totalPrice += newQuantity * product.getPrice();

                cartItems.remove(item);
                cartItems.add(new CartItem(product, newQuantity));
                return;
            }
        }

        // new item to be added.
        totalPrice += quantity * product.getPrice();
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeItem (Product product, int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        for (CartItem item : cartItems) {
            if(item.getProduct() == product){
                int newQuantity = item.getQuantity() - quantity;
                if(newQuantity < 0){
                    throw new IllegalArgumentException("Needed amount is lager than the product quantity in the cart");
                }
                totalPrice -= quantity * product.getPrice();
                cartItems.remove(item);
            }
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void clear() {
        cartItems.clear();
        totalPrice = 0;
    }

}
