package com.annaseva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annaseva.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
