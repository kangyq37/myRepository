package com.kangyq.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService8408Main {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8408Main.class,args);
    }
}
