package com.example.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
