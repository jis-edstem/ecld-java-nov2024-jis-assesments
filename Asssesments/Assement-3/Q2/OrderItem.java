public class OrderItem {
    private String productId;
    private int quantity;
    private double pricePerUnit;

    public OrderItem(String productId, int quantity, double pricePerUnit) {
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }
}