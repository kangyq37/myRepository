package com.kangyq.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class NacosConfig9003Main {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig9003Main.class,args);
    }
}
