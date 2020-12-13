package com.jzt.service.impl;

import com.jzt.dao.IPaymentDao;
import com.jzt.service.IPaymentService;
import entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sj
 */
@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private IPaymentDao iPaymentDao;

    @Override
    public int addPayment(Payment payment) {
        return iPaymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return iPaymentDao.getPaymentById(id);
    }
}
