package com.gyoomi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/10/14 22:15
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 基本转发
     * 当访问http://localhost:8080/jd
     * 转发到http://jd.com
     *
     * @param builder b
     * @return RouteLocator
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/jd")
                        .uri("http://jd.com:80/")
                        .id("jd_route")
                ).build();
    }
}
