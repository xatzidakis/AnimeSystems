package com.animesystems.services;

import com.animesystems.entities.Order;
import com.animesystems.entities.OrderItem;
import org.springframework.data.domain.Page;

import java.util.List;


public interface OrderService {


    Order save(Order order);
    void deleteById(Integer id);
    public Order findById(Integer id);
    public List<Order> getAllOrders();
}
