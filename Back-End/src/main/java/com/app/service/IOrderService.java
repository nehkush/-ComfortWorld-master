package com.app.service;

import com.app.model.Order;
import com.app.model.User;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    // Create
    Order createOrder(Order order);

    // Read
    Optional<Order> getOrderById(Long id);

    List<Order> getAllOrders();

    // Update
    Order updateOrder(Long id, Order updatedOrder);

    // Delete
    void deleteOrder(Long id);

    // Additional methods (if needed)
    // Example: Find orders by customer name
    List<Order> getOrdersByCustomerName(String customerName);
    
    //List<Order> findByUserId(User user);
    List<Order> findByUserId(Long userId);

	
}
