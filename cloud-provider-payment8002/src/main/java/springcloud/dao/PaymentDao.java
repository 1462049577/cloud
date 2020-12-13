package springcloud.dao;

import com.gyx.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: GuoGua
 * @Date: 2020/10/25 0025 11:09
 * @Description: null..
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}