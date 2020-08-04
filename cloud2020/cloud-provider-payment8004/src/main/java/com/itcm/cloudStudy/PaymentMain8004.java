package com.itcm.cloudStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 * 支付模块启动类
 *
 * @outhor cm_fighting
 * @create 2020-07-30 3:53 下午
 */
@SpringBootApplication
@EnableDiscoveryClient // 用于向 zk 或着 consul 注册中心注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
