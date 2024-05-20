package com.example.mongodbreactive.service;

import com.example.mongodbreactive.dto.ProductDto;
import com.example.mongodbreactive.repository.ProductRepository;
import com.example.mongodbreactive.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Flux<ProductDto> getAll() {
        return productRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }
    public Mono<ProductDto> getProductById(String id) {
        return productRepository.findById(id)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono) {
       return productDtoMono.map(EntityDtoUtil::toEntity)
                .flatMap(productRepository::insert)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {
        return productRepository.findById(id)
                .flatMap(p -> productDtoMono
                        .map(EntityDtoUtil::toEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(productRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<Void> deleteProductById(String id) {
        return productRepository.deleteById(id);
    }
}


