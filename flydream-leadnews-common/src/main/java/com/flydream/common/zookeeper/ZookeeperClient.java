package com.flydream.common.zookeeper;

import com.flydream.common.zookeeper.sequence.ZkSequence;
import com.flydream.common.zookeeper.sequence.ZkSequenceEnum;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 功能描述
 *通过PostConstruct注解在内构器之后调用
 * init方法初始化客户端连接，并调用initZkSequence方法初始项目所定义的ZkSequence，并存储在
 * zkSequence的Map集合中，最终提供sequence方法来查询对应zkSequence获取自增ID
 * @author: scott
 * @date: 2023年06月21日 16:26
 */
@Setter
@Getter
public class ZookeeperClient {

    Logger logger = LoggerFactory.getLogger(ZookeeperClient.class);

    private String host;
    private String sequencePath;

    // 重试休眠时间
    private final int SLEEP_TIME_MS = 1000;
    // 最大重试1000次
    private final int MAX_RETRIES = 1000;
    //会话超时时间
    private final int SESSION_TIMEOUT = 30 * 1000;
    //连接超时时间
    private final int CONNECTION_TIMEOUT = 3 * 1000;

    CuratorFramework client = null;

    // 序列化集合
    private Map<String, ZkSequence> zkSequenceMap = Maps.newConcurrentMap();

    public ZookeeperClient(String host, String sequencePath) {
        this.host = host;
        this.sequencePath = sequencePath;
    }

    @PostConstruct
    public void init() {
        this.client = CuratorFrameworkFactory.builder().connectString(this.getHost())
                .connectionTimeoutMs(CONNECTION_TIMEOUT)
                .sessionTimeoutMs(SESSION_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(SLEEP_TIME_MS, MAX_RETRIES)).build();
        this.client.start();
        this.initZkSequence();
    }

    public void initZkSequence() {
        ZkSequenceEnum[] list = ZkSequenceEnum.values();
        for (int i = 0; i < list.length; i++) {
            String name = list[i].name();
            String path = this.sequencePath + name;
            ZkSequence zkSequence = new ZkSequence(path, this.client);
            zkSequenceMap.put(name, zkSequence);
        }
    }

    public Long sequence(ZkSequenceEnum name) {
        try {
            ZkSequence seq = zkSequenceMap.get(name.name());
            if (seq != null) {
                return seq.sequence();
            }
        } catch (Exception e) {
            logger.error("获取[{}]Sequence错误:{}",name,e);
            e.printStackTrace();
        }
        return null;

    }
}
