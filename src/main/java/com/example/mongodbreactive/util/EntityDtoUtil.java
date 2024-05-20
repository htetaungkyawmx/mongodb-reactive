package com.example.mongodbreactive.util;

import com.example.mongodbreactive.dto.ProductDto;
import com.example.mongodbreactive.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(product,dto);
        return dto;
    }
    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }
}
