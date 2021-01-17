package com.ksisn.pub;

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
        ZkUtils.pub(topic, msg);
    }

    public static void main(String[] args) {

    }
}
