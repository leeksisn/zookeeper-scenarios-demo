package com.ksisn.sub;

import com.ksisn.SubListener;
import com.ksisn.ZkUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author kevin.lee
 * @date 2021/1/18 15:50
 */
public class App {

    private static String topic = "topic1";

    public static void main(String[] args) throws InterruptedException {

        ZkUtils.sub(topic, new SubListener() {
            @Override
            public void afterReceived(String latestMsg) {
                System.out.println(latestMsg);
            }
        });
        // 休息10分钟，保证能持续获取消息
        TimeUnit.MINUTES.sleep(10);
    }
}
