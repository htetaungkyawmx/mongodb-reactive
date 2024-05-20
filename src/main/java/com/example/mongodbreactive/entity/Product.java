package com.example.mongodbreactive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String description;
    private double price;

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
    }
}
