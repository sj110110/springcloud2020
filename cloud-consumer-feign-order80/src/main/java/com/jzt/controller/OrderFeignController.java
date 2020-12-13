package com.jzt.controller;

import com.jzt.service.PaymentFeignService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/11/28 18:40
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }

    @RequestMapping(value = "/consumer/payment/feign/timeout")
    public String paymentTimeout(){
        //客户端一般默认等待1s钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
