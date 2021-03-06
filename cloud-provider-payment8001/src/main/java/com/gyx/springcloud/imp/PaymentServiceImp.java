package com.gyx.springcloud.imp;

import com.gyx.springcloud.dao.PaymentDao;
import com.gyx.springcloud.entitys.Payment;
import com.gyx.springcloud.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: GuoGua
 * @Date: 2020/10/25 0025 11:32
 * @Description: null..
 */
@Service
public class PaymentServiceImp implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}