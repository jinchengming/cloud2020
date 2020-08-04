package com.itcm.cloudStudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-08-03 11:25 上午
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class OrderConsukMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsukMain80.class, args);
    }
}
