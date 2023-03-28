package com.animesystems.entities;

import jakarta.persistence.*;

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    public ProductOrder(){


    }

    public ProductOrder(Order order , Product product , Integer quantity){
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getId(){

        return this.id;
    }

    public Order getOrder(){

        return this.order;
    }

    public void setOrder(Order order){
        this.order=order;
    }

    public Product getProduct(){

        return this.product;

    }

    public void setProduct(Product product){

        this.product = product;

    }

    public Integer getQuantity(){

        return this.quantity;

    }

    public  void setQuantity(Integer quantity){

        this.quantity = quantity;

    }


}
