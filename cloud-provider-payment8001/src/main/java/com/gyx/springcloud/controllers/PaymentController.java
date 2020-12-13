package com.gyx.springcloud.controllers;

import com.gyx.springcloud.entitys.CommonResult;
import com.gyx.springcloud.entitys.Payment;
import com.gyx.springcloud.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: GuoGua
 * @Date: 2020/10/25 0025 11:33
 * @Description: null..
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private PaymentService paymentService;

    /**
     * 创建操作
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    public CommonResult creat(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("***********插入结果:" + i);
        if (i > 0) {
            return new CommonResult(200, "插入成了" + serverPort, i);
        } else {
            return new CommonResult(500, "插入失败了", null);
        }

    }

    /**
     * id查询操作
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("***********id查询结果:" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成了" + serverPort, paymentById);
        } else {
            return new CommonResult(500, "没有对应记录,查询失败", null);
        }
    }

    /**
     * 服务发现
     *
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object discovery() {
        //表示多个微服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("element: " + service);
        }
        //表示某个微服务拥有的集群
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getLB() {
        return serverPort;
    }
    @GetMapping("/payment/feign/out")
    public String paymentFeignout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}