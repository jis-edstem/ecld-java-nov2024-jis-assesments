import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        RegularOrder order1 = new RegularOrder("ORD001", "Jis");
        order1.addItem(new OrderItem("P001", 2, 10.0));
        order1.addItem(new OrderItem("P002", 1, 15.0));
        orderProcessor.processOrder(order1);

        RegularOrder order2 = new RegularOrder("ORD002", "Jacob");
        order2.addItem(new OrderItem("P003",1,50.0));
        order2.addItem(new OrderItem("P004",3,80.0));
        orderProcessor.processOrder(order2);

        PriorityOrder porder1 = new PriorityOrder("ORD003", "Jisy", true, 25.0);
        porder1.addItem(new OrderItem("P005", 2, 80.0));
        orderProcessor.processOrder(porder1);

        System.out.println("Total Revenue: ₹" + orderProcessor.getTotalRevenue());
        System.out.println("Average Order Value: ₹" + orderProcessor.getAverageOrderValue());
        System.out.println("Top Customer List: " + orderProcessor.getTopCustomers(2));

        System.out.println("All Orders:");
        Iterator<Order> orderIterator = orderProcessor.iterator();
        while(orderIterator.hasNext()) {
            Order order = orderIterator.next();
            System.out.printf("Order ID: %s, Customer: %s, Total: ₹%.2f%n",
                    order.orderId, order.getCustomerName(), order.calculateTotal());
        }
    }
}
