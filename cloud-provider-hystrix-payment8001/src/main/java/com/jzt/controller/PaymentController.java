package com.jzt.controller;

import com.jzt.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/12/4 21:46
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
       String result = paymentService.paymentInfo_OK(id);
       log.info("result ---:"+result);
       return result;
    }

    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("result ---:"+result);
        return result;
    }

    @RequestMapping("/payment/hystrix/timeout2/{id}")
    public String paymentInfo_Timeout2(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_Timeout2(id);
        log.info("result ---:"+result);
        return result;
    }

    //服务熔断
    @RequestMapping("/payment/hystrix/circuitBreak/{id}")
    public String paymentCircuitBreak(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreak(id);
        log.info("result ---:"+result);
        return result;
    }
}
