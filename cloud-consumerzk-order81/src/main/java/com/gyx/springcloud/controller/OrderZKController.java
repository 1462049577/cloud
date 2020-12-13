package com.gyx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: GuoGua
 * @Date: 2020/11/8 0008 17:37
 * @Description: null..
 */
@RestController
@Slf4j
public class OrderZKController {

    private static final String INVOK_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        String forObject = restTemplate.getForObject(INVOK_URL + "/payment/zk", String.class);
        return forObject;
    }

}