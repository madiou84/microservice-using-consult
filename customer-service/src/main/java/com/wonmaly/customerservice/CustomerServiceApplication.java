package com.wonmaly.customerservice;

import com.wonmaly.customerservice.customer.Customer;
import com.wonmaly.customerservice.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers = customerRepository.saveAll(List.of(
                    Customer.builder().name("Madiou").email("mmadioubah@gmail.com").build(),
                    Customer.builder().name("Saikou").email("infosaikou@gmail.com").build(),
                    Customer.builder().name("Doukouré").email("doukoure@gmail.com").build(),
                    Customer.builder().name("TLB").email("tlb@gmail.com").build(),
                    Customer.builder().name("Yaya").email("mmadioubah@gmail.com").build(),
                    Customer.builder().name("Oury").email("oury@gmail.com").build(),
                    Customer.builder().name("Ibrahim").email("ib@gmail.com").build()
            ));

            customers.forEach(System.out::println);
        };
    }

}
