package com.animesystems.services;

import com.animesystems.entities.Order;
import com.animesystems.entities.ProductOrder;
import com.animesystems.repositories.OrderRepository;
import com.animesystems.repositories.ProductOrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductOrderRepository productOrderRepository;

    public OrderServiceImpl(OrderRepository orderRepository,ProductOrderRepository productOrderRepository){
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
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

    public ProductOrder getProductOrderById(Integer id) throws Exception {
        Optional<ProductOrder> optionalProductOrder = productOrderRepository.findById(id);
        if (!optionalProductOrder.isPresent()) {
            throw new Exception("ProductOrder not found with id " + id);
        }
        return optionalProductOrder.get();
    }

}
