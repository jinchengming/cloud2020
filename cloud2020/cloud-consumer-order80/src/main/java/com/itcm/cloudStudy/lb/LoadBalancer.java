package com.itcm.cloudStudy.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 描述: 自定义负载均衡算法-接口
 *
 * @outhor cm_fighting
 * @create 2020-08-03 5:52 下午
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}