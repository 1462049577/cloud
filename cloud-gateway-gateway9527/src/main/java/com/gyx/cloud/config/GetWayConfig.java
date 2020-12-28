package com.gyx.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GuoGua
 * @Date: 2020/12/28 0028 14:49
 * @Description: null..
 */
@Configuration
public class GetWayConfig {
    @Bean
    public RouteLocator routeLocator (RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                        .build();
        return routes.build();
    }
    @Bean
    public RouteLocator routeLocator1 (RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }

}