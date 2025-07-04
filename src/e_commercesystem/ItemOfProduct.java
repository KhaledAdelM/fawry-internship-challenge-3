package e_commercesystem;


public class ItemOfProduct {
     private Product product;
    private int quantity;

    public ItemOfProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
