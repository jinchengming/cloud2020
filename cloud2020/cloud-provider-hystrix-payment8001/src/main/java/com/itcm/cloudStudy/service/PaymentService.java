package com.itcm.cloudStudy.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 描述: 测试Hystrix
 *
 * @outhor cm_fighting
 * @create 2020-08-04 6:19 下午
 */
@Service
public class PaymentService {

    // 正常请求
    public String paymentInfo_OK(Integer id) {
        return "线程: " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + "\tO(∩_∩)O哈哈~";
    }

    // 模拟超时
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
//        int num = 10/0 除了超时 类似这种程序运行异常 也是可以成功走降级的方法
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程: " + Thread.currentThread().getName() + " paymentInfo_TimeOut, id: " + id + "\t耗时" + timeNumber + "秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程: " + Thread.currentThread().getName() + "系统繁忙，请稍后再试 ... " + "\to(╯□╰)o";
    }

    //  ** 服务熔断 **
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            // 以下配置解读 在时间窗口期内（10s内）10次请求中 有6次（60%）都是失败
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 请求窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率阈值
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t 调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后再试， o(╥﹏╥)o  ， id : " + id;
    }


}
