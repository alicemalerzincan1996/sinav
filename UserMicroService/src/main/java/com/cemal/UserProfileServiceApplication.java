package com.cemal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UserProfileServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProfileServiceApplication.class);
    }
}