package ECommerce.Interfaces;

import java.util.ArrayList;

public interface ShippingServiceInterface {
    void ship(ArrayList<Shippable> items);
}