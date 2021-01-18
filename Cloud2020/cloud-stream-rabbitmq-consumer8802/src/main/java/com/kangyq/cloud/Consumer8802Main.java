package com.kangyq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Consumer8802Main {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8802Main.class,args);
    }
}
