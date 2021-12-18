package com.example.productpromotions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductPromotionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductPromotionsApplication.class, args);
    }

}
