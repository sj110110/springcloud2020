package com.jzt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/10/25 11:26
 */
@SpringBootApplication
@EnableDiscoveryClient  //使用consul或者zookeeper作为注册中心时注册服务
public class PaymentService8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentService8004.class, args);
    }
}
