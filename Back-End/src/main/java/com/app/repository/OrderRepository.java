package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Order;
import com.app.model.User;

public interface OrderRepository extends JpaRepository<Order, Long>
{
       // List<Order>	findByUserId(User user);
	List<Order> findByName(String customerName);
	List<Order> findByUserId(Long userId);
}
