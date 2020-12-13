package com.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/11/27 21:19
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule getRule(){
        //随机
        return new RandomRule();
    }
}
