package com.jzt.controller;

import com.jzt.lb.LoadBancer;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/10/16 7:30
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URI = "http://localhost:8001";//单机版
    public static final String PAYMENT_URI = "http://CLOUD-PAYMENT-SERVICE";//集群版

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBancer loadBancer;

    @GetMapping("consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URI+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/create2")
    public CommonResult<Payment> create2(Payment payment){
        return restTemplate.postForEntity(PAYMENT_URI+"/payment/create", payment, CommonResult.class).getBody();
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URI+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id") Long id){
          ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URI+"/payment/get/"+id, CommonResult.class);
          if(entity.getStatusCode().is2xxSuccessful()){
              return entity.getBody();
          }else{
              return new CommonResult<>(444, "操作失败");
          }
    }

    @GetMapping("consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances(PAYMENT_URI);

        if(instances == null || instances.size() == 0){
            return null;
        }

        ServiceInstance serviceInstance = loadBancer.instances(instances);
        URI uri =serviceInstance.getUri();

        return  restTemplate.getForObject(uri+"/payment/lb", String.class);

    }
}
