package com.kangyq.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

        public String paymentInfo_ok(Integer id){
            return "线程池"+Thread.currentThread().getName()+" paymentInfo_Ok()"+id;
        }

        @HystrixCommand(fallbackMethod = "payment_handler",commandProperties = {
                @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds" ,value = "5000")
        })
        public String paymentInfo_error(Integer id){

            int timeOut = 3000;
//            int age = 10/0;

            try {
                TimeUnit.MILLISECONDS.sleep(timeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "线程池"+Thread.currentThread().getName()+" paymentInfo_error(),超时时间："+timeOut;
        }

        public String payment_handler(Integer id){
            return "线程池"+Thread.currentThread().getName()+" paymentHandler********************";
        }


        //======================服务熔断===============================

    @HystrixCommand(fallbackMethod = "fallback_paymentCircuitBreak_method",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer Id){
            if (Id < 0) {
                throw new RuntimeException("ID 不能为负数");
            }
            String serialNumber = IdUtil.randomUUID();
            return Thread.currentThread().getName()+"\t"+"调用成功serialNumber: "+serialNumber;
    }

    private String fallback_paymentCircuitBreak_method(Integer Id){
        return Thread.currentThread().getName()+"\t"+"**************调用失败，ID不能为负数！**********************";
    }
}

