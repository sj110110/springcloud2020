package com.jzt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 * @author sj
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentService8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentService8002.class, args);
    }
}
