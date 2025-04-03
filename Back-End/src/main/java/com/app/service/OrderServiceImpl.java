package com.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Order;
import com.app.model.User;
import com.app.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;

    
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
    

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {
        if (orderRepository.existsById(id)) {
            updatedOrder.setId(id);
            return orderRepository.save(updatedOrder);
        } else {
            // Handle the case where the order with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrdersByCustomerName(String customerName) {
        return orderRepository.findByName(customerName);
    }
    public Order saveOrder(Order order) {
        // Set orderNumber and orderDateTime before saving
        order.setOrderNumber(generateOrderNumber()); // You can implement your own logic
        
        return orderRepository.save(order);
    }

    public String generateOrderNumber() {
        // Implement your logic to generate a unique order number
        // Example: return a combination of date and a random number
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
                + new Random().nextInt(1000);
    }



	/*
	 * @Override public List<Order> findByUserId(User user) { // TODO Auto-generated
	 * method stub return orderRepository.findByUserId(user); }
	 */



	@Override
	public List<Order> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return orderRepository.findByUserId(userId);
	}

   

	
}
