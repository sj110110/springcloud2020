package com.jzt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/12/6 16:14
 */
@SpringBootApplication
@EnableHystrixDashboard//启动仪表盘注解
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args );
    }
}
