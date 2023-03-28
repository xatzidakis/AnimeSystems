package com.animesystems.services;

import com.animesystems.entities.Order;
import com.animesystems.entities.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public void deleteOrder(Integer id);
    public Order createOrUpdateOrder(Integer id, Order order) throws Exception;
    public Page<Order> getAllOrders(int page, int size);
    public  Order getOrderById(Integer id);
    public ProductOrder getProductOrderById(Integer id) throws Exception;


}
