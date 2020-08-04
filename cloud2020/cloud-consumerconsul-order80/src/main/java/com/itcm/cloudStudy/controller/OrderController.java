package com.itcm.cloudStudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-08-03 11:28 上午
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @GetMapping(value = "consumer/consul")
    public String consumerConsul() {
        String s = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return s;
    }
}
