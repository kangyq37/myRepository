package com.kangyq.springcloud.controller;

import com.kangyq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {


    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String isOk(@PathVariable("id") Integer Id){
        log.info("123");
        return paymentService.paymentInfo_ok(Id);
    }


    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String isError(@PathVariable("id") Integer Id){
        log.info("456");
        return paymentService.paymentInfo_error(Id);
    }


    //========服务熔断================

    @GetMapping(value = "/payment/hystrix/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer Id){
        log.info("==========================================================服务熔断=============================");
        return paymentService.paymentCircuitBreaker(Id);
    }

}
