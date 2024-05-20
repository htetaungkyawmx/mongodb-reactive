package com.example.mongodbreactive.controller;

import com.example.mongodbreactive.dto.ProductDto;
import com.example.mongodbreactive.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/all")
    public Flux<ProductDto> findAllProducts() {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductDto>> getProductById(@PathVariable String id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Mono<ProductDto> createProduct(@RequestBody Mono<ProductDto> productDtoMono) {
        return productService.insertProduct(productDtoMono);
    }
    @PutMapping("/{id}")
    public Mono<ResponseEntity<ProductDto>> updateProduct (
            @PathVariable String id,
            @RequestBody Mono<ProductDto> productDtoMono) {

        return productService.updateProduct(id, productDtoMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return productService.deleteProductById(id);
    }

}
