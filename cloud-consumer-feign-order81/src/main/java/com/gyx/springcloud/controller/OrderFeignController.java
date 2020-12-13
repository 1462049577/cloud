package com.gyx.springcloud.controller;

import com.gyx.springcloud.entitys.CommonResult;
import com.gyx.springcloud.entitys.Payment;
import com.gyx.springcloud.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: GuoGua
 * @Classname OrderFeignController
 * @Date: 2020/11/22 0022 15:14
 * @Description: null..
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("consumer/payment/feign/timeout")
    public String paymentTimeout(){
        return paymentFeignService.paymentFeignout();
    }
}