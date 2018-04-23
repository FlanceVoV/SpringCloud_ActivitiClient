package me.git.weizechen.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("me.git.weizechen.dao")
@ComponentScan(basePackages = {"me.git.weizechen"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"me.git.weizechen"})
@EnableCircuitBreaker
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}