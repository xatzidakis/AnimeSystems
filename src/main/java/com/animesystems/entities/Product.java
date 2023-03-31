package com.animesystems.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    public Product(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal price;
    private String description;
    private String title;
    private String photo;

    public enum Category {
        Figures, Clothing, Books
    }

    @Enumerated(EnumType.STRING)
    private Category category;

    public enum Color{
        Black, White, Red, Yellow, Blue, Green
    }

    @Enumerated(EnumType.STRING)
    private Color color;

    public enum Size{ XS, S, M, L, XL}

    @Enumerated(EnumType.STRING)
    private Size size;
    private Integer available_quantity;

}



