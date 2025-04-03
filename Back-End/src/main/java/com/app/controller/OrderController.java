package com.app.controller;

import com.app.model.Order;
import com.app.model.User;
import com.app.service.IOrderService;
import com.app.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/orders")
public class OrderController {

    private final IOrderService orderService;
    @Autowired
UserServiceImpl userServiceImpl;
    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Order> createOrder(@RequestBody Order order,@PathVariable String id) {
    	                   User user=  userServiceImpl.getUserById(Long.parseLong(id)).get();
    	                   order.setUser(user);
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
    
	/*
	 * @GetMapping("/order/{id}") public ResponseEntity<List<Order>>
	 * getUserOrders(@PathVariable("id") String id) { User
	 * user=userServiceImpl.getUserById(Long.parseLong(id)).get(); List<Order> list=
	 * orderService.findByUserId(user); return new
	 * ResponseEntity<>(list,HttpStatus.OK); }
	 */
    @GetMapping("/order/{id}")
    public ResponseEntity<?> getUserOrders(@PathVariable("id") String id) {
        try {
            Long userId = Long.parseLong(id);
            List<Order> list = orderService.findByUserId(userId);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid user ID", HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/{userid}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long userid) {
        Optional<Order> order = orderService.getOrderById(userid);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order order = orderService.updateOrder(id, updatedOrder);
        return order != null ?
                new ResponseEntity<>(order, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byCustomerName")
    public ResponseEntity<List<Order>> getOrdersByCustomerName(@RequestParam String customerName) {
        List<Order> orders = orderService.getOrdersByCustomerName(customerName);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
