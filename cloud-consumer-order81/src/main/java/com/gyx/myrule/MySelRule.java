package com.gyx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GuoGua
 * @Date: 2020/11/15 0015 16:06
 * @Description: null..
 */
@Configuration
public class MySelRule {
    @Bean
    public IRule myIRule(){
        return new RandomRule();
    }
}