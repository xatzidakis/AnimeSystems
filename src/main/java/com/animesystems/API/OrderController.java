package com.animesystems.API;

import com.animesystems.dtos.OrderItemDTO;
import com.animesystems.entities.Order;
import com.animesystems.entities.Product;
import com.animesystems.entities.OrderItem;
import com.animesystems.services.OrderService;
import com.animesystems.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;


    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }



    @PostMapping
    public Order createOrder(@RequestBody List<OrderItemDTO> orderItemDTOs) {
        String address = "aaaa";
        Order order = new Order();
        order.setTotalPrice(0.0);
        order.setAddress(address);
        Double pr = 0.0;

        for (OrderItemDTO orderItemDTO : orderItemDTOs) {

            Product product = productService.getProductById(orderItemDTO.getProductId());

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(orderItemDTO.getQuantity());

            order.addOrderItem(orderItem);
            BigDecimal myQuantity = new BigDecimal(orderItemDTO.getQuantity());

            Double price = product.getPrice().doubleValue();

            pr += orderItemDTO.getQuantity()*price;
        }


        order.setTotalPrice( pr);
        order = orderService.save(order);

        return order;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        Order order = orderService.findById(id);

        if (order == null) {
            // Throw an exception or handle the error in some way
        }

        return order;
    }


    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Integer id) {
        Order order = orderService.findById(id);

        if (order == null) {
            // Throw an exception or handle the error in some way
        }

        orderService.deleteById(id);
    }
}







