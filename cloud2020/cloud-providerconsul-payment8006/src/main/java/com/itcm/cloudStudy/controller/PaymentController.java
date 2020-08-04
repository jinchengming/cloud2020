package com.itcm.cloudStudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-08-03 10:59 上午
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("consul")
    public String paymentConsul() {
        return "spring cloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
