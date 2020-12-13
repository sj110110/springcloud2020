package com.jzt.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述：
 *
 * @Author: sj
 * @Date: 2020/11/28 11:59
 */
public class MyLoadBancer implements LoadBancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        for(;;){
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            if(this.atomicInteger.compareAndSet(current, next)) {
                System.out.println("*****第几次访问，次数next:"+next);
                return next;
            }
        }
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
