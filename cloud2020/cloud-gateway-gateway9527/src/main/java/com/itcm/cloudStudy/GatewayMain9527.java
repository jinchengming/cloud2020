package com.itcm.cloudStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 描述:
 * 网关gateway微服务主启动类
 *
 * @outhor cm_fighting
 * @create 2020-08-11 2:03 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }

}
