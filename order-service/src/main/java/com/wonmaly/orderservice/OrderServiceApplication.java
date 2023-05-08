package com.wonmaly.orderservice;

import com.wonmaly.orderservice.order.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClientService customerRestClientService,
            InventoryRestClientService inventoryRestClientService) {
        return args -> {
            List<Customer> allCustomers = customerRestClientService.allCustomers().getContent().stream().toList();
            List<Product> allProducts = inventoryRestClientService.allProducts().getContent().stream().toList();

            allProducts.forEach(System.out::println);
            allCustomers.forEach(System.out::println);

            Random random = new Random();
            Long customerId = allCustomers.get(1).getId();

            customerRestClientService.findCustomerById(customerId);

            for (int i = 0; i < 20; i++) {
                Order order = Order.builder()
                        .customerId(
                                allCustomers.get(random.nextInt(
                                        allCustomers.size()
                                )).getId()
                        )
                        .status(Math.random() > 0.5 ? OrderStatus.PENDING : OrderStatus.CREATED)
                        .createdAt(new Date())
                        .build();
                Order savedOrder = orderRepository.save(order);

                allProducts.forEach(product -> {
                    if (Math.random() > 0.7) {
                        ProductItem productItem = ProductItem.builder()
                                .order(savedOrder)
                                .productId(product.getId())
                                .price(product.getPrice())
                                .quantity(1 + random.nextInt(10))
                                .discount(Math.random())
                                .build();

                        productItemRepository.save(productItem);
                    }
                });
            }
        };
    }

}
