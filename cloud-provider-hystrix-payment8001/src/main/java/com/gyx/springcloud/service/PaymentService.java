package com.gyx.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: GuoGua
 * @Date: 2020/12/8 0008 11:12
 * @Description: null..
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK"+id;
    }
    @HystrixCommand(fallbackMethod = "payment_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
    })
    public String paymentInfo_Timeout(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_Timeout"+id;
    }
    //服务降级
    public String payment_TimeoutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"系统繁忙>>>>>>>"+id;
    }
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentInfo_Circuit",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")// 失败率
            // 加起来就是在10s内的10次请求中如果失败超过6次进入服务熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return "调用成功："+serialNumber;
    }

    public String paymentInfo_Circuit(Integer id){
        return "id不能为负数："+id;
    }
}