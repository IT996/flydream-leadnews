package com.flydream.common.zookeeper.sequence;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 功能描述
 *用于封装程序在运行时每个表对
 * 应的自增器，这里主要通过分布式原子自增类（DistributedAtomicLong）实现，注意每500毫秒重试3
 * 次后仍然生成失败则返回null，由上层处理
 * @author: scott
 * @date: 2023年06月21日 10:42
 */
public class ZkSequence {

    RetryPolicy retryPolicy = new ExponentialBackoffRetry(500, 3);

    DistributedAtomicLong distAtomicLong;

    public ZkSequence(String sequenceName, CuratorFramework client){
        distAtomicLong = new DistributedAtomicLong(client,sequenceName,retryPolicy);
    }
    /**
     * 生成序列
     * @return
     * @throws Exception
     */
    public Long sequence() throws Exception {
        AtomicValue<Long> sequence = this.distAtomicLong.increment();
        if (sequence.succeeded()) {
            return sequence.postValue();
        } else {
            return null;
        }
    }
}
