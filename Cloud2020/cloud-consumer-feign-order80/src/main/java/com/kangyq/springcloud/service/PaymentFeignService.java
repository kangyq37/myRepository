package com.kangyq.springcloud.service;

import com.kangyq.springcloud.entities.CommonResult;
import com.kangyq.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {


//    @GetMapping(value = "/payment/getPaymentById/{id}")
//    CommonResult<Payment> getPaymentById(Long Id);

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long Id);
}
