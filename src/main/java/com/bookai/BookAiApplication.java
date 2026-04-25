package com.bookai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookAiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookAiApplication.class, args);
    }
}