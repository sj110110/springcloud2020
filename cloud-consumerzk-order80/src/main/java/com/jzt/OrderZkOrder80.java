package com.jzt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/11/10 7:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkOrder80.class, args);
    }
}
