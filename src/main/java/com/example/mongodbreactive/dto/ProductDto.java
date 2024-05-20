package com.example.mongodbreactive.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data @ToString
@Getter @Setter
public class ProductDto {
    private String id;
    private String description;
    private double price;
}
