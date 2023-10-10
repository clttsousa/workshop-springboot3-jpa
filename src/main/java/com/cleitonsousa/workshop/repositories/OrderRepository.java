package com.cleitonsousa.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleitonsousa.workshop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
