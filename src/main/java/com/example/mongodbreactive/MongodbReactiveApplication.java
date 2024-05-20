package com.example.mongodbreactive;

import com.example.mongodbreactive.entity.Product;
import com.example.mongodbreactive.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class MongodbReactiveApplication {
    private final ProductRepository productRepository;
    @Bean
    public ApplicationRunner runner() {
        return r ->{
            Product product1=new Product("Guitar",2000);
            Product product2=new Product("Piano",4000);
            Product product3=new Product("violin",6000);
            productRepository.save(product1).subscribe();
            productRepository.save(product2).subscribe();
            productRepository.save(product3).subscribe();
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(MongodbReactiveApplication.class, args);
    }

}
