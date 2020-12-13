package com.jzt.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/12/13 11:30
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    /**
     * 该过滤方法作用是校验是否有合法的username
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("****{MyLogGatewayFilter} start.");
        String username =exchange.getRequest().getQueryParams().getFirst("username");
        if(username == null){
            log.info("**** 非法用户！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * Ordered中的int getOrder()方法是来给过滤器设定优先级别的，值越大则优先级越低。
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
