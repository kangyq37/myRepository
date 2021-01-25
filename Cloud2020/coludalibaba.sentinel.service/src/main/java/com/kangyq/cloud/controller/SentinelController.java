package com.kangyq.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelController {

    @GetMapping("/testA")
    @SentinelResource(value = "testA" ,blockHandler = "deal_blockHandler",fallback = "deal_fallBack")
    public String  test(){
        log.info("testA");
        return "testA";
    }

    @GetMapping("/testB")
    /**
     * blockHandler 征对 sentinel exception
     * fallback 针对 runtime Exception
     */
    @SentinelResource(value = "testB" ,blockHandler = "deal_blockHandler",fallback = "deal_fallBack")
    public String testB(){
        log.info("testB");
        return "testB";
    }


    public String deal_blockHandler(){
        return "sentinel Exception";
    }

    public String deal_fallBack(){
        return "runtime Exception";
    }
}
