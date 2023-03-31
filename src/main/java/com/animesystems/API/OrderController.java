package com.animesystems.API;
import com.animesystems.dtos.OrderDTO;
import com.animesystems.dtos.OrderItemDTO;
import com.animesystems.dtos.UserDto;
import com.animesystems.entities.Order;
import com.animesystems.entities.Product;
import com.animesystems.entities.OrderItem;
import com.animesystems.mapper.UserMapper;
import com.animesystems.services.OrderService;
import com.animesystems.services.ProductService;
import com.animesystems.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;

    public OrderController(OrderService orderService, ProductService productService,UserService userService) {
        this.orderService = orderService;
        this.productService = productService;
        this.userService = userService;
    }



    @PostMapping()
    public Order createOrder(@RequestBody OrderDTO orderDTO) {

        UserDto userDto = userService.getUserById(orderDTO.getUserId());
        Order order = new Order();
        order.setAddress(orderDTO.getAddress());
        order.setTotalPrice(0.0);
        order.setUser(UserMapper.mapToUser(userDto));

        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {

            Product product = productService.getProductById(orderItemDTO.getProductId());

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(orderItemDTO.getQuantity());

            order.addOrderItem(orderItem);
            order.addToTotalPrice(orderItemDTO.getQuantity()*product.getPrice().doubleValue());
        }

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







