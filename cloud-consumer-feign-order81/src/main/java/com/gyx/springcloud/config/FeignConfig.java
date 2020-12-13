package com.gyx.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GuoGua
 * @Classname FeignConfig
 * @Date: 2020/11/29 0029 18:02
 * @Description: null..
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level fiLevelLoggerLevel(){

        return Logger.Level.FULL;
    }
}
