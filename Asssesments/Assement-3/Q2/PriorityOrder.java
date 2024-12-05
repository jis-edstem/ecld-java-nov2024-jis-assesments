public class PriorityOrder extends Order {
    private boolean expressShipping;
    private double expressFee;

    public PriorityOrder(String orderId, String customerName, boolean expressShipping, double expressFee) {
        super(orderId, customerName);
        this.expressShipping = expressShipping;
        this.expressFee = expressFee;
    }

    public double calculateTotal() {
        double total = 0;
        for(OrderItem item: items){
            total += item.getTotalPrice();
        }
        if(expressShipping) {
            total += expressFee;
        }
        return total;
    }

    public double calculateDiscount() {
        return 0;
    }
}
