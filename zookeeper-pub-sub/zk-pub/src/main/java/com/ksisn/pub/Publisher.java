package com.ksisn.pub;


import com.ksisn.ZkUtils;

import java.util.UUID;

/**
 * @author kevin.lee
 * @date 2021/1/18 0018
 */
public class Publisher {

    private String topic;

    public Publisher(String topic) {
        this.topic = topic;
    }

    public void destroy() {
        ZkUtils.deleteRecursive(topic);
    }

    public void send(String msg) {
        // 设置每次请求均含有不同的UUID
        PullController.messages.addLast(msg);
        ZkUtils.pub(topic, PullController.PULL_MSG_URL + "?_id=" + (UUID.randomUUID().toString()));
    }
}
