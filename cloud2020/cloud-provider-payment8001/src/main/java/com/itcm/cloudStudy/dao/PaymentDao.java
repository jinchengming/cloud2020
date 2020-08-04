package com.itcm.cloudStudy.dao;

import com.itcm.cloudStudy.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-07-30 6:22 下午
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}