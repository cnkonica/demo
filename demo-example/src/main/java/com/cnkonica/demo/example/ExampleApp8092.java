package com.cnkonica.demo.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.cnkonica.demo.example.mapper")
public class ExampleApp8092 {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApp8092.class,args);
    }
}
