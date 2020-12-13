package com.jzt.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/12/4 21:37
 */
@Service
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallBackMethod")
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"paymentInfo_OKm id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id){
        int time = 5;
        int a = 1/0;//异常报错
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+"paymentInfo_Timeout id:"+id+"\t"+"O(∩_∩)O哈哈~, 耗时："+time;
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"paymentInfo_TimeoutHandler,系统忙，请稍后再试！ o(╥﹏╥)o";
    }

    @HystrixCommand
    public String paymentInfo_Timeout2(Integer id){
        int a = 1/0;//异常报错
        return "线程池： "+Thread.currentThread().getName()+"paymentInfo_Timeout2 id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    //全局fallback方法
    public String payment_global_fallBackMethod(){
        return "payment_global_fallBackMethod,系统忙，请稍后再试！ o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少跳闸
    })
    public String paymentCircuitBreak(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("----id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+" 调用成功，id:"+serialNumber;
    }
    public String paymentCircuitBreak_fallBack(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试！ o(╥﹏╥)o, id:"+id;
    }

}
