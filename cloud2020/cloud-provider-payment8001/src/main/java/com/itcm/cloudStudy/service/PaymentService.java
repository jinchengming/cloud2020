package com.itcm.cloudStudy.service;

import com.itcm.cloudStudy.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-07-30 6:46 下午
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}