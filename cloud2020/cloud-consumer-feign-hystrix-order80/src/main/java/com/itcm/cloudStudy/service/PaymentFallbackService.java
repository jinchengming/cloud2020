package com.itcm.cloudStudy.service;

import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-08-06 11:06 上午
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK , o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_TimeOut , o(╥﹏╥)o";
    }
}
