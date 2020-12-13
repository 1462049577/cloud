package springcloud.controllers;

import com.gyx.springcloud.entitys.CommonResult;
import com.gyx.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GuoGua
 * @Date: 2020/10/25 0025 11:33
 * @Description: null..
 */
@RestController
@Slf4j
public class PaymentController {
    /**
     * 用来获取端口
     */
    @Value("${server.port}")
    private String serverPort;

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
    @GetMapping("/payment/lb")
    public String getLB(){
        return serverPort;
    }


}