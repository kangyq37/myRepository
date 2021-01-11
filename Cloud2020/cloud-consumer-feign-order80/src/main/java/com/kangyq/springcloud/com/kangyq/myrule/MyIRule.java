package com.kangyq.springcloud.com.kangyq.myrule;

import com.netflix.loadbalancer.IRule;
//随机
import com.netflix.loadbalancer.RandomRule;
//轮询
import com.netflix.loadbalancer.RoundRobinRule;
//权重
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyIRule {

    @Bean
    public IRule getMyIRule(){
        return new WeightedResponseTimeRule();
    }
}
