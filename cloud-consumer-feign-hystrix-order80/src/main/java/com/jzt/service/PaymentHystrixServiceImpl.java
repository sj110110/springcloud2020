package com.jzt.service;

import org.springframework.stereotype.Component;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/12/6 10:49
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixServiceImpl paymentInfo_OK, O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentHystrixServiceImpl paymentInfo_Timeout, o(╥﹏╥)o";
    }
}
