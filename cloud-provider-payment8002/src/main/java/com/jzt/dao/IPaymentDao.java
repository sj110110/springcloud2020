package com.jzt.dao;

import entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sj
 */
@Mapper
public interface IPaymentDao {

    int addPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
