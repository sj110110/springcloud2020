package com.jzt.service;

import entities.Payment;
import org.apache.ibatis.annotations.Param;


/**
 * @author sj
 */
public interface IPaymentService {
    public int addPayment(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
