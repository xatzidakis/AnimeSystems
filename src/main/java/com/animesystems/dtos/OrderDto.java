package com.animesystems.dtos;

import com.animesystems.entities.Order;

import java.math.BigDecimal;
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




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
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


    public Integer getUserId() {
        return this.user.getId();
    }
}
