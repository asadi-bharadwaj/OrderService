package com.orderService.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderService.OrderService.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
