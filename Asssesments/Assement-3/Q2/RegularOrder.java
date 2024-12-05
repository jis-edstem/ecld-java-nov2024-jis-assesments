public class RegularOrder extends Order {
    private double minimumForDiscount = 100.0;
    private double discountPercent = 0.10;

    public RegularOrder(String orderId, String customerName) {
        super(orderId, customerName);
    }

    public double calculateTotal() {
        double total = 0;
        for(OrderItem item: items){
            total += item.getTotalPrice();
        }
        return total;
    }

    public double calculateDiscount() {
        double total = calculateTotal();
        if(total >= minimumForDiscount) {
            return total * discountPercent;
        }
        return 0;
    }
}
