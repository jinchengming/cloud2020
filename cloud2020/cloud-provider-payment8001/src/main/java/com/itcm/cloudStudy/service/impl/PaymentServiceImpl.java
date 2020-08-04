package com.itcm.cloudStudy.service.impl;

import com.itcm.cloudStudy.dao.PaymentDao;
import com.itcm.cloudStudy.entities.Payment;
import com.itcm.cloudStudy.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-07-30 6:47 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
