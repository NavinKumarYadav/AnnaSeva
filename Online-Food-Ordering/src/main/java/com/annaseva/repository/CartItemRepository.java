package com.annaseva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annaseva.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
