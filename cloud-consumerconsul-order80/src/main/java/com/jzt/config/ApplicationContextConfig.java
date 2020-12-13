package com.jzt.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/11/10 7:24
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //开启负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
