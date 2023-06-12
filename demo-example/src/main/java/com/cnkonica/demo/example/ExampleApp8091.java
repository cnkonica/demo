package com.cnkonica.demo.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ExampleApp8091 {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApp8091.class,args);
    }
}
