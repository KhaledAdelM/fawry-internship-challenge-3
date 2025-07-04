package e_commercesystem;

import java.util.*;


public class Cart {
     private List<ItemOfProduct> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (!product.isAvailable(quantity)) {
            //System.out.println("");
        }
        items.add(new ItemOfProduct(product, quantity));
    }

    public List<ItemOfProduct> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double total = 0;
        for (ItemOfProduct item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
