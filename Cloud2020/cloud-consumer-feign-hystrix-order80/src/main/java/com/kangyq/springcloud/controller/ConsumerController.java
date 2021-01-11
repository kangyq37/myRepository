package com.kangyq.springcloud.controller;

import com.kangyq.springcloud.service.ConsumerOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "")
public class ConsumerController {

    @Resource
    private ConsumerOrderService consumerOrderService;


    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String isOk(@PathVariable("id") Integer Id){
        return consumerOrderService.isOk(Id);
    }


    @GetMapping(value = "/consumer/payment/hystrix/error/{id}")
    @HystrixCommand(fallbackMethod = "payment_handler",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String isError(@PathVariable("id") Integer Id){
        return consumerOrderService.isError(Id);
    }

    public String payment_handler(@PathVariable("id") Integer Id){
        return "消费者：出错页面显示"+Thread.currentThread().getName();
    }
}
