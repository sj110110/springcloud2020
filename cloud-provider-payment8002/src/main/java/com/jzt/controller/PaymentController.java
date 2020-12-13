package com.jzt.controller;

import com.jzt.service.IPaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sj
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.addPayment(payment);
        log.info("****插入数据："+result);
        int a = 0/1;
        if(result > 0){
            return new CommonResult(200, "插入数据成功！,server port:"+port,result);
        }else{
            return new CommonResult(502, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询数据："+payment);
        if(payment != null){
            return new CommonResult(200, "查询数据成功！,server port:"+port,payment);
        }else{
            return new CommonResult(502, "查询数据失败，查询ID:"+id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }
}
