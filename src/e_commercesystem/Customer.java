package e_commercesystem;


public class Customer {
     private String name;
    private double balance;

    public Customer(String name, double balance) {
        setName(name);
        setBalance(balance);
    }

    public boolean canAfford(double amount) {
        return balance >= amount;
    }

    public void deduct(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) System.out.println("Balance cannot be negative");
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Customer name cannot be empty");
        this.name = name;
    }
}

