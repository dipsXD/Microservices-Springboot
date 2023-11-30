package com.tutorial.orderservice.orderservice.repository;

import com.tutorial.orderservice.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
