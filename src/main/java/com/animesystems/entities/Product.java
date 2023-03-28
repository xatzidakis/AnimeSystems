package com.animesystems.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal price;
    private String description;
    private String title;
    private String photo;
    private String category;
    @Enumerated(EnumType.STRING)
    private Color color;
    public enum Color {
        RED("Red"),
        BLUE("Blue"),
        GREEN("Green"),
        YELLOW("Yellow"),
        BLACK("Black"),
        WHITE("White");

        private final String name;

        private Color(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public String getColor() {
        return color.getName();
    }
    public enum Size {
        XS("XS"),
        S("S"),
        M("M"),
        L("L"),
        XL("XL");

        private final String name;

        private Size(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    @Enumerated(EnumType.STRING)
    private Size size;
    public String getSize() {
        return size.getName();
    }
    private Integer available_quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(Integer available_quantity) {
        this.available_quantity = available_quantity;
    }
}
