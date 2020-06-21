package com.saan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LaptopServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaptopServiceApplication.class, args);
    }

}
