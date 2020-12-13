package com.gyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: GuoGua
 * @Date: 2020/11/8 0008 17:19
 * @Description: null..
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain81.class,args);
    }
}