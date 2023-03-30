package com.animesystems.repositories;

import com.animesystems.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<OrderItem, Integer> {

}