package com.kangyq.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 * 自定义过滤器 //全局日志
 * @author kangyq
 * @data 2021/1/9
 */
@Component
@Slf4j
public class MyGlobalGatewayFilter implements Ordered , GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************************进去自定义过滤器****************************");
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (null == username){
            log.info("！！！！！！！！！！！！！！！！用户名不能为空！！！！！！！！！！！！！！！！！！！！！！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
