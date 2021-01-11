package com.kangyq.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface ConsumerOrderService {


    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String isOk(@PathVariable("id") Integer Id);


    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String isError(@PathVariable("id") Integer Id);


}
