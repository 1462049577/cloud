package com.gyx.springcloud;

import com.gyx.springcloud.entitys.CommonResult;
import com.gyx.springcloud.entitys.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: GuoGua
 * @Classname PaymentFeignService
 * @Date: 2020/11/22 0022 15:07
 * @Description: null..
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id);
    @GetMapping("/payment/feign/out")
    public String paymentFeignout();
}