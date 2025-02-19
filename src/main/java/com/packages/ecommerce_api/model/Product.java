package com.packages.ecommerce_api.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_products")
@Schema(description = "Product entity  e table representing an item in the e-commerce platform")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the product", example = "1")
    private Long id;

    @Column
    @Schema(description = "Name of the product", example = "Laptop")
    private String name;

    @Column
    @Schema(description = "Description of the product", example = "High-performance laptop with 16GB RAM")
    private String description;

    @Column
    @Schema(description = "Price of the product", example = "999.99")
    private double price;


    public Product() {}
    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

