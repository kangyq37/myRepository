package com.kangyq.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class NacosConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceURL ;

    @GetMapping("/consumer/provider/get")
    public String getInfo(){
        log.info("***********************************************进入客户端83*************************");
        return restTemplate.getForObject(serviceURL+"/provider/get",String.class);
    }
}
