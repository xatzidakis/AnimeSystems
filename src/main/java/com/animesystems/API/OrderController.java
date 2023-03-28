package com.animesystems.API;
import com.animesystems.dtos.OrderDto;
import com.animesystems.dtos.ProductOrderDto;
import com.animesystems.entities.Order;
import com.animesystems.entities.Product;
import com.animesystems.entities.ProductOrder;
import com.animesystems.entities.User;
import com.animesystems.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    @Autowired
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








    // -------------------------------------------------------------

    //Help !

//
//    @PostMapping
//    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
//        Order order = new Order();
//        order.setAddress(orderDto.getAddress());
//        order.setUser(new User(orderDto.getUserId()));
//        for (ProductOrderDto productOrderDto : orderDto.getProductOrders()) {
//            ProductOrder productOrder = new ProductOrder();
//            productOrder.setProduct(new Product(productOrderDto.getProductId()));
//            productOrder.setQuantity(productOrderDto.getQuantity());
//            order.addProductOrder(productOrder);
//        }
//        Order createdOrder = orderService.createOrder(order);
//        return new OrderDto(createdOrder);
//    }
//
//
//    public Order updateOrder(@PathVariable("id") Integer id, @RequestBody OrderDto orderDto) {
//        Order order = orderService.getOrderById(id);
//
//        User user = new User(orderDto.getUserId());
//        order.setUser(user);
//        order.setAddress(orderDto.getAddress());
//
//        List<ProductOrder> productOrders = new ArrayList<>();
//        for (ProductOrderDto productOrderDto : orderDto.getProductOrders()) {
//            Product product = new Product(productOrderDto.getProductId());
//            ProductOrder productOrder = new ProductOrder(productOrderDto.getQuantity(), product, order);
//            productOrders.add(productOrder);
//        }
//        order.setProductOrders(productOrders);
//
//        return orderService.createOrUpdateOrder(order);
//    }



}




