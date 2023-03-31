package com.animesystems.dtos;
import java.util.List;
public class OrderDTO {

    private String address;
    private List<OrderItemDTO> orderItems;
    private Integer userId;

    public OrderDTO() {
    }

    public OrderDTO(String address, List<OrderItemDTO> orderItems,Integer userId) {
        this.address = address;
        this.orderItems = orderItems;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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