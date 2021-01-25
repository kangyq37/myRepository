package com.kangyq.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NacosProvider9001Controller {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/provider/get")
    public String get(){
        return "nacos provider ,server-port: "+serverPort;
    }
}
