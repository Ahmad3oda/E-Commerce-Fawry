package ECommerce.Models;

import java.time.LocalDate;
import java.util.Date;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, double weight, int quantity, int days) {
        super(name, price, weight, quantity);
        this.expiryDate = LocalDate.now().plusDays(days);
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
