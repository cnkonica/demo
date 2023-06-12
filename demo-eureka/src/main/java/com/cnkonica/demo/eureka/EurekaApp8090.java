package com.cnkonica.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lixiaolong
 * @date 2020/12/19 14:12
 * @description 注册中心
 */
@SpringBootApplication
@EnableEurekaServer // 设置为服务注册中心 EurekaServer
public class EurekaApp8090 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp8090.class, args);
        System.out.println("启动成功");
    }
}
