package com.gyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: GuoGua
 * @Date: 2020/12/10 0010 11:23
 * @Description: null..
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain81.class,args);
    }
}