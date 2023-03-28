package com.animesystems.API;
import com.animesystems.dtos.OrderDto;
import com.animesystems.dtos.ProductOrderDto;
import com.animesystems.entities.Order;
import com.animesystems.entities.Product;
import com.animesystems.entities.ProductOrder;
import com.animesystems.entities.User;
import com.animesystems.mapper.UserMapper;
import com.animesystems.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {



    private final OrderService orderService;


    public OrderController(OrderService orderService){
        this.orderService = orderService;


    }


    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Integer id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        orderService.deleteOrder(id);
    }

    @GetMapping
    public Page<Order> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return orderService.getAllOrders(page, size);
    }




    @PostMapping("/orders")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) throws Exception {
        // Map the OrderDto to an Order entity
        Order order = new Order();
        order.setUser(UserMapper.mapToUser(orderDto.getUserDto()));
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setAddress(orderDto.getAddress());

        List<ProductOrder> productOrders = new ArrayList<>();
        for (ProductOrderDto productOrderDto : orderDto.getProductOrders()) {
            ProductOrder productOrder = new ProductOrder();
            productOrder.setQuantity(productOrderDto.getQuantity());
            productOrder.setProduct(new Product(productOrderDto.getProductId()));
            productOrders.add(productOrder);
        }
        order.setProductOrders(productOrders);

        // Save the Order entity using the OrderService
        Order savedOrder = orderService.createOrUpdateOrder(order.getId(),order);

        // Map the saved Order entity to an OrderDto and return it
        return new OrderDto(savedOrder);
    }

    @PutMapping("/orders/{id}")
    public OrderDto updateOrder(@PathVariable Integer id, @RequestBody OrderDto orderDto) throws Exception {
        // Retrieve the existing Order entity from the OrderService
        Order existingOrder = orderService.getOrderById(id);
        if (existingOrder == null) {
            throw new Exception("Order with id " + id + " does not exist.");
        }

        // Map the OrderDto to the existing Order entity
        existingOrder.setUser(UserMapper.mapToUser(orderDto.getUserDto()));
        existingOrder.setTotalPrice(orderDto.getTotalPrice());
        existingOrder.setAddress(orderDto.getAddress());

        List<ProductOrder> productOrders = new ArrayList<>();
        for (ProductOrderDto productOrderDto : orderDto.getProductOrders()) {
            ProductOrder productOrder;
            if (productOrderDto.getId() != null) {
                productOrder = orderService.getProductOrderById(productOrderDto.getId());
                if (productOrder == null) {
                    throw new Exception("ProductOrder with id " + productOrderDto.getId() + " does not exist.");
                }
            } else {
                productOrder = new ProductOrder();
            }
            productOrder.setQuantity(productOrderDto.getQuantity());
            productOrder.setProduct(new Product(productOrderDto.getProductId()));
            productOrders.add(productOrder);
        }
        existingOrder.setProductOrders(productOrders);

        // Save the updated Order entity using the OrderService
        Order savedOrder = orderService.createOrUpdateOrder(existingOrder.getId(),existingOrder);

        // Map the saved Order entity to an OrderDto and return it
        return new OrderDto(savedOrder);
    }






}




