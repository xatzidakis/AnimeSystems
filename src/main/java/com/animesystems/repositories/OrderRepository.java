package com.animesystems.repositories;

import com.animesystems.entities.Order;
import com.animesystems.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
