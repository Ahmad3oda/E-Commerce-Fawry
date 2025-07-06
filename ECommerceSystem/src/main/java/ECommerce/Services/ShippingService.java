package ECommerce.Services;

import ECommerce.Interfaces.Shippable;
import ECommerce.Interfaces.ShippingServiceInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShippingService implements ShippingServiceInterface {
    @Override
    public void ship(ArrayList<Shippable> items) {
        Map<String, Integer> itemFreq = new HashMap<>();
        Map<String, Double> itemWeight = new HashMap<>();

        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            itemFreq.put(name, itemCounts.getOrDefault(name, 0) + 1);
            itemWeight.put(name, weight);
            totalWeight += weight;
        }

        System.out.println("----------------------");
        for (String name : itemCounts.keySet()) {
            int count = itemFreq.get(name);
            double weight = itemWeight.get(name);
            System.out.printf("%dx %s %.0fkg%n", count, name, weight);
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
