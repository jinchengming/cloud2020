package com.itcm.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: 负载均衡规则配置
 *
 * @outhor cm_fighting
 * @create 2020-08-03 2:42 下午
 */

@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule(); // 随机
    }
}
