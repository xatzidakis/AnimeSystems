package com.animesystems.dtos;

import com.animesystems.entities.Order;
import com.animesystems.entities.ProductOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private Integer id;


    private UserDto user;

    private BigDecimal totalPrice;

    private List<ProductOrderDto> productOrders;

    private String address;

    public OrderDto() {
    }

    public OrderDto(UserDto user) {
        this.user = user;
    }

    public OrderDto(Order order) {
        this.id = order.getId();
        this.totalPrice = order.getTotalPrice();
        List<ProductOrderDto> productOrderDtos = new ArrayList<>();
        for(ProductOrder productOrder: order.getProductOrders()) {
            ProductOrderDto productOrderDto = new ProductOrderDto();
            productOrderDto.setId(productOrder.getId());
            productOrderDto.setProductId(productOrder.getProduct().getId());
            productOrderDto.setQuantity(productOrder.getQuantity());
            productOrderDtos.add(productOrderDto);
        }
        this.productOrders = productOrderDtos;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductOrderDto> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrderDto> productOrders) {
        this.productOrders = productOrders;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
