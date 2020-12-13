package com.jzt.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/11/28 11:55
 */
public interface LoadBancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
