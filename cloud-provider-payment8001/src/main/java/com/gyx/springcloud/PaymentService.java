package com.gyx.springcloud;

import com.gyx.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: GuoGua
 * @Date: 2020/10/25 0025 11:31
 * @Description: null..
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}