package com.itcm.cloudStudy.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * 网关配置类
 *
 * @author cm_fighting
 * @create 2020-08-11 3:11 下午
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("path_route_bd", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
    }
}
