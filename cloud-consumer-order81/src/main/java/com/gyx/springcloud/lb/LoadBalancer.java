package com.gyx.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GuoGua
 * @Classname LoadBalancer
 * @Date: 2020/11/21 0021 17:12
 * @Description: null..
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
