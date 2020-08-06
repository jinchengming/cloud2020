package com.itcm.cloudStudy.controller;

import com.itcm.cloudStudy.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-08-05 3:01 下午
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") // controller层来控制指定默认的降级
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService hystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id) {
        return hystrixService.paymentInfo_OK(id);

    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @HystrixCommand
    String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return hystrixService.paymentInfo_TimeOut(id);
    }

    String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) {
        return "我是消费方80，对方支付系统繁忙，请稍后再试 o(╯□╰)o";
    }

    // 全局fallback方法, 在类上通过@DefaultProperties注解指定
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试 o(╥﹏╥)o";
    }


}
