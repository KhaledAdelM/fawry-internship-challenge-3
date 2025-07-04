package e_commercesystem;

import java.util.*;

public class ShippingPrinter {
    public static void ship(List<Product> items) {
        
        Map<String, Integer> itemCounts = new HashMap<>();
        Map<String, Double> itemWeights = new HashMap<>();
        double totalWeight = 0;

        for (Product item : items) {
            itemCounts.put(item.getName(), itemCounts.getOrDefault(item.getName(), 0) + 1);
            itemWeights.put(item.getName(), item.getWeight());
            totalWeight += item.getWeight();            
        }

        System.out.println("\n** Shipment notice **");
        for (String name : itemCounts.keySet()) {
            int count = itemCounts.get(name);
            double weight = itemWeights.get(name);
            System.out.printf("%dx %-12s %.0fg\n", count, name, weight);
        }
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight / 1000.0);
    }
}
