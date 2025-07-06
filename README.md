# E-Commerce-Fawry
Direct Path for the project code: ECommerceSystem/src/main/java/ECommerce

# Simple E-Commerce Checkout System

A simple Java-based e-commerce checkout system that supports:

- Expirable and non-expirable products
- Shippable and non-shippable products
- Cart management and checkout validation
- Shipping item grouping and weight calculation

---

##  Project Structure

```markdown
ecommerce/
├── models/
│   ├── Product.java
│   ├── ExpirableProduct.java
│   ├── CartItem.java
│   ├── Cart.java
│   └── Customer.java
│
├── services/
│   ├── CheckoutService.java
│   └── ShippingService.java
│
├── interfaces/
│   └── Shippable.java
│   └── CheckoutServiceInterface.java
│   └── ShippingServiceInterface.java│
└── Main.java
````

---

## Sample Scenario

```java
Customer customer = new Customer("Ali", 10000, "6 October");
Product tv = new Product("TV", 2500, 30, 1000);
Product scratchCard = new Product("Scratch Card", 15, 0, 100000);
ExpirableProduct cheese = new ExpirableProduct("Cheese", 80, 1, 100, 10);

Cart cart = new Cart();
cart.addItem(tv, 2);
cart.addItem(scratchCard, 2);
cart.addItem(cheese, 2);

customer.setCart(cart);

CheckoutService checkoutService = new CheckoutService();
checkoutService.checkout(customer);

ShippingService shippingService = new ShippingService();
shippingService.ship(checkoutService.getShippableItems());
````

---

## Sample Output

```
** Checkout receipt **
2x TV 5000
2x Scratch Card 30
2x Cheese 160
----------------------
Subtotal 5190
Shipping 93
Amount 5283
Remaining Balance 4717
----------------------
2x TV 30kg
2x Cheese 1kg
Total package weight 62.0kg
```

---

## Requirements & Behavior

* Products have: name, price, quantity
* Products may optionally:

  * Expire after a number of days (e.g., cheese)
  * Require shipping (with a specified weight)
* Cart validates:

  * No expired or out-of-stock items
  * Customer has enough balance
* Checkout:

  * Prints subtotal, shipping fees, and remaining balance
* Shipping:

  * Collects all shippable items
  * Displays grouped shipment details and total weight

---

## Run Instructions

* Java 8+ required
* Compile and run `Main.java` from your IDE or terminal

---

```
```
