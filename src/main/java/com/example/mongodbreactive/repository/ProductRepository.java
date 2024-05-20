package com.example.mongodbreactive.repository;

import com.example.mongodbreactive.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
