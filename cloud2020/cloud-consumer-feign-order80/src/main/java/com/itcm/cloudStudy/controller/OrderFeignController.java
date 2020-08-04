package com.itcm.cloudStudy.controller;

import com.itcm.cloudStudy.entities.CommonResult;
import com.itcm.cloudStudy.entities.Payment;
import com.itcm.cloudStudy.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-08-04 10:42 上午
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/getFeign/{id}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒
        return paymentFeignService.paymentFeignTimeout();
    }
}
