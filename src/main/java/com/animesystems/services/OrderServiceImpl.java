package com.animesystems.services;

import com.animesystems.entities.Order;
import com.animesystems.repositories.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }



    public void deleteOrder(Integer id) {
        Order orderToDelete = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(orderToDelete);

    }


    public Order createOrUpdateOrder(Integer id, Order order) throws Exception {

        if(id!=null){
            if(id.equals(order.getId())){
                throw new Exception("Id does not match");
            }
        }
        return this.orderRepository.save(order);
    }


    public Page<Order> getAllOrders(int page, int size) {
        PageRequest paging = PageRequest.of(page,size);

        return orderRepository.findAll(paging);

    }


    public Order getOrderById(Integer id) {
        Order orderToFind= orderRepository.findById(id).orElseThrow();
        return orderToFind;
    }

}
