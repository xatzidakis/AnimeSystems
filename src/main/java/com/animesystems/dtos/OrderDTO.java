package com.animesystems.dtos;

import com.animesystems.dtos.OrderItemDTO;

import java.util.List;

public class OrderDTO {
    private String address;
    private List<OrderItemDTO> orderItems;


    public OrderDTO() {
    }

    public OrderDTO(String address, List<OrderItemDTO> orderItems) {
        this.address = address;
        this.orderItems = orderItems;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}