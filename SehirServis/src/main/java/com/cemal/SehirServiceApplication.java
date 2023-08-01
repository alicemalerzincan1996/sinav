package com.cemal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SehirServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SehirServiceApplication.class);
    }
}