import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected String orderId;
    protected String customerName;
    protected LocalDateTime orderDate;
    protected List<OrderItem> items;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public abstract double calculateTotal();
    public abstract double calculateDiscount();

    public String getCustomerName(){
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
