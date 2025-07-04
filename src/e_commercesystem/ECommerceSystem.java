package e_commercesystem;

import java.time.LocalDate;
import java.util.*;

public class ECommerceSystem {
    

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }

        List<Product> toShip = new ArrayList<>();
        double subtotal = 0;

        for (ItemOfProduct item : cart.getItems()) {
            Product p = item.getProduct();

            if (p.isExpirable() && p.isExpired()) {
                System.out.println("Warning: Product " + p.getName() + " is expired and will be skipped.");
                continue;
            }

            if (!p.isAvailable(item.getQuantity())) {
                System.out.println("Warning: Product " + p.getName() + " is out of stock and will be skipped.");
                continue;
            }

            subtotal += item.getTotalPrice();

            if (p.isShippable()) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    toShip.add(p);
                }
            }
        }

        double shipping = toShip.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {
            System.out.println("Error: Insufficient balance");
            return;
        }

        customer.deduct(total);
        for (ItemOfProduct item : cart.getItems()) {
            Product p = item.getProduct();
            if (p.isExpirable() && p.isExpired()) continue;
            if (!p.isAvailable(item.getQuantity())) continue;
            p.reduceQuantity(item.getQuantity());
        }

        if (!toShip.isEmpty()) {
            ShippingPrinter.ship(toShip);
        }

        System.out.println("** Checkout receipt **");
        for (ItemOfProduct item : cart.getItems()) {
            Product p = item.getProduct();
            if (p.isExpirable() && p.isExpired()) continue;
            if (!p.isAvailable(item.getQuantity())) continue;
            System.out.printf("%-15s x%-2d %8.0f\n", p.getName(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("%-20s %8.0f\n", "Subtotal", subtotal);
        System.out.printf("%-20s %8.0f\n", "Shipping", shipping);
        System.out.printf("%-20s %8.0f\n", "Amount", total);
        System.out.printf("%-20s %8.0f\n", "Balance", customer.getBalance());

        
    }
    
    
    private final static double MAX_BALANCE = 1000;
    
    public static void main(String[] args) {
        Customer customer = new Customer("KHaled", MAX_BALANCE);

       Product cheese = new Product("Cheese", 100, 5, true,  LocalDate.parse("2025-10-01"), true, 200);
        Product biscuits = new Product("Biscuits", 150, 2, true, LocalDate.parse("2025-01-01"), true, 700);
        Product tv = new Product("TV", 100, 0, false, null, true, 3000);
        Product scratchCard = new Product("Windows card", 50, 10, false, null, false, 0);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        checkout(customer, cart);
    }
   }
