package com.edstem.ecld.assesment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    private final String customerId;
    private final double amount;
    private final List<String> items;
    private final LocalDate orderDate;

    // Constructor
    public Order(String customerId, double amount, List<String> items, LocalDate orderDate) {
        this.customerId = customerId;
        this.amount = amount;
        this.items = items;
        this.orderDate = orderDate;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}

// OrderAnalyzer class
class OrderAnalyzer {

    public Map<String, Double> analyzeOrders(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getOrderDate().getYear() == 2024) // Filter orders from 2024 strictly
                .filter(order -> order.getAmount() > 100) // Filter orders above $100
                .collect(Collectors.groupingBy(
                        Order::getCustomerId, // Group by customerId
                        Collectors.summingDouble(Order::getAmount) // Sum the order amounts
                ));
    }
}

// Main class to test the implementation
public class OrderManagement {
    public static void main(String[] args) {
        // Example input
        List<Order> orders = Arrays.asList(
                new Order("C1", 150.0, Arrays.asList("Item1", "Item2"), LocalDate.of(2024, 1, 15)),
                new Order("C1", 50.0, Arrays.asList("Item3", "Item5"), LocalDate.of(2024, 1, 20)),
                new Order("C2", 200.0, Arrays.asList("Item1", "Item4"), LocalDate.of(2024, 1, 15)),
                new Order("C1", 120.0, Arrays.asList("Item2", "Item5"), LocalDate.of(2023, 12, 15))
        );

        // Create an instance of OrderAnalyzer
        OrderAnalyzer analyzer = new OrderAnalyzer();

        // Analyze the orders
        Map<String, Double> result = analyzer.analyzeOrders(orders);

        // Print the result
        System.out.println("Customer ID -> Total Order Amount (Above $100 in 2024):");
        result.forEach((customerId, totalAmount) ->
                System.out.println(customerId + " -> " + totalAmount)
        );
    }
}