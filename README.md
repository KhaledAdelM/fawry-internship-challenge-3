# Fawry E-Commerce System

> Java implementation for the **Fawry Quantum Internship Challenge 3** — built using **Object-Oriented Programming** principles and clean, modular code.

---

## 🚀 Features

- 🛍️ Add multiple products to a shopping cart
- 📆 Handle expirable products (e.g., food, medicine)
- 📦 Handle shippable products with shipping cost & weight
- 🧾 Generate a receipt including subtotal, shipping, total, and remaining balance
- ⚠️ Skip expired or out-of-stock products without stopping the entire process

---

## 🧱 System Components

| Class             | Description                                                             |
| ----------------- | ----------------------------------------------------------------------- |
| `Product`         | Represents a product with optional expiry and shipping features         |
| `Customer`        | Stores customer data and manages balance deduction                      |
| `CartItem`        | Wraps a product and quantity as one unit in the cart                    |
| `Cart`            | Holds multiple items and calculates subtotal                            |
| `ShippingPrinter` | Calculates and displays shipping details (counts, weight)               |
| `Main`            | Contains the core checkout logic and entry point for running the system |

---

## 📄 Sample Console Output 
  - Notes
      * Balance = 1000
      * Shipping = 30
```
Warning: Product Biscuits is expired and will be skipped.
Warning: Product TV is out of stock and will be skipped.

** Shipment notice **
2x Cheese       200g
Total package weight 0.4kg

** Checkout receipt **
Cheese          x2       200
Windows card    x1        50
----------------------
Subtotal                  250
Shipping                   30
Amount                    280
Balance                   720
```

---

## ✅ OOP Best Practices Used

- **Encapsulation**: All fields are private with public getters/setters
- **Composition over inheritance**: Used boolean flags instead of subclassing for product types
- **Validation**: Handled for names, prices, quantities, and balances
- **SRP**: Each class has a clear single responsibility

---

## 🛠 How to Run

1. Open the project in your preferred Java IDE (e.g., IntelliJ, Eclipse)
2. Compile and run the `Main.java` class
3. Observe the checkout process and receipt in the console output

---

## 📌 Notes

- This is a simulation of a basic e-commerce checkout system. It can be improved by decoupling product behaviors like expiry and shipping into dedicated interfaces.
  - Refactor `Product` class to use interfaces like `Expirable` and `Shippable` instead of combining all behaviors into one class

---

## 👤 Author

- Developed by: **Khaled Adel**
- Challenge: **Fawry Internship Challenge 3**
- Language: **Java**
