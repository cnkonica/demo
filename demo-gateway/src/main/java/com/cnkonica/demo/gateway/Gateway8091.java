package com.cnkonica.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Gateway8091 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway8091.class, args);
    }
}
