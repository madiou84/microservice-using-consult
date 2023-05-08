package com.wonmaly.inventoryservice;

import com.wonmaly.inventoryservice.product.Product;
import com.wonmaly.inventoryservice.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository productRepository) {
        Random random = new Random();
        return args -> {
            List<Product> products = productRepository.saveAll(List.of(
                    Product.builder().name("Apple")
                            .price(1000 + Math.random() * 1000)
                            .quantity(1 + random.nextInt(200)).build(),
                    Product.builder().name("Samsung")
                            .price(1000 + Math.random() * 1000)
                            .quantity(1 + random.nextInt(200)).build(),
                    Product.builder().name("Mac book Air")
                            .price(1000 + Math.random() * 1000)
                            .quantity(1 + random.nextInt(200)).build(),
                    Product.builder().name("Apple")
                            .price(1000 + Math.random() * 1000)
                            .quantity(1 + random.nextInt(200)).build(),
                    Product.builder().name("Dell")
                            .price(1000 + Math.random() * 1000)
                            .quantity(1 + random.nextInt(200)).build()
            ));

            products.forEach(System.out::println);
        };
    }

}
