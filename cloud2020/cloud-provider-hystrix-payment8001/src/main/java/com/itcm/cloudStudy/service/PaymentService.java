package com.itcm.cloudStudy.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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


}
