package com.itcm.cloudStudy.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: OpenFeign 日志配置
 *
 * @outhor cm_fighting
 * @create 2020-08-04 12:27 下午
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
