package ECommerce.Services;

import ECommerce.Interfaces.Shippable;
import ECommerce.Interfaces.ShippingServiceInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShippingService implements ShippingServiceInterface {
    @Override
    public void ship(ArrayList<Shippable> items) {
        Map<String, Integer> itemCounts = new HashMap<>();
        Map<String, Double> itemWeights = new HashMap<>();

        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            itemCounts.put(name, itemCounts.getOrDefault(name, 0) + 1);
            itemWeights.put(name, weight);
            totalWeight += weight;
        }

        for (String name : itemCounts.keySet()) {
            int count = itemCounts.get(name);
            double weight = itemWeights.get(name) * 1000;
            System.out.printf("%dx %s %.0fg%n", count, name, weight);
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
