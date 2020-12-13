package com.gyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: GuoGua
 * @Classname OrderFeignMain81
 * @Date: 2020/11/22 0022 15:03
 * @Description: null..
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain81.class,args);
    }
}