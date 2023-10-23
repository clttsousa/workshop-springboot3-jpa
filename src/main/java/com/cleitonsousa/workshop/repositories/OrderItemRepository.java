package com.cleitonsousa.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleitonsousa.workshop.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
