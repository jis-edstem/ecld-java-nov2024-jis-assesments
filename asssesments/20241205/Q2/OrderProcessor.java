import java.util.*;

public class OrderProcessor {
    private List<Order> orders;
    private double totalRevenue;

    public OrderProcessor() {
        orders = new LinkedList<>();
        totalRevenue = 0;
    }

    public void processOrder(Order order) {
        orders.add(order);
        totalRevenue += order.calculateTotal();
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public double getAverageOrderValue() {
        return orders.isEmpty() ? 0 : totalRevenue / orders.size();
    }

    public List<Order> getOrdersByCustomer(String customerName) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    public List<String> getTopCustomers(int n) {
        Map<String, Double> customerTotals = new HashMap<>();
        for (Order order : orders) {
            customerTotals.put(order.getCustomerName(), customerTotals.getOrDefault(order.getCustomerName(), 0.0) + order.calculateTotal());
        }
        return customerTotals.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Iterator<Order> iterator() {
        return orders.iterator();
    }
}