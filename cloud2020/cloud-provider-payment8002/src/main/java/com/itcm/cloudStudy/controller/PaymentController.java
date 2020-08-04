package com.itcm.cloudStudy.controller;

import com.itcm.cloudStudy.entities.CommonResult;
import com.itcm.cloudStudy.entities.Payment;
import com.itcm.cloudStudy.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-07-30 10:53 下午
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：{}", result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,server port : " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果：{}", payment);
        if (null != payment) {
            return new CommonResult(200, "查询成功, server port: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    // 模拟超时
    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }

}
