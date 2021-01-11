package com.kangyq.springcloud.controller;

import com.kangyq.springcloud.entities.CommonResult;
import com.kangyq.springcloud.entities.Payment;
import com.kangyq.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PaymentController {

    private Logger logger = LoggerFactory.getLogger(PaymentController.class);

    private static final  String str  = "CLOUD-PROVIDER-PAYMENT";

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        logger.info("插入结果："+result);
        return result > 0 ? new CommonResult(200,"插入成功,serverPort: " + serverPort,result):new CommonResult(404,"插入数据失败",null);
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long Id){
        Payment payment = paymentService.getPaymentById(Id);
        logger.info("查询结果123456："+payment);
        return payment !=null  ? new CommonResult(200,"查询数据成功,serverPort: " + serverPort,payment)
                : new CommonResult(404,"查询数据失败，ID："+Id,null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            logger.info("--------------------element:{}",service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances(str);

        for (ServiceInstance instance : instances) {
            logger.info("instanceId:"+instance.getInstanceId()+"\t"+"host:"+instance.getHost()+"\t"
                    +instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
