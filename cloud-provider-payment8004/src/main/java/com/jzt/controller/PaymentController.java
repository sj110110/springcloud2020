package com.jzt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/10/25 15:46
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "zookeeper :"+port+"\t"+ UUID.randomUUID().toString();
    }

}
