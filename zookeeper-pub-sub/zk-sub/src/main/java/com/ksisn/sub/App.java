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

        TimeUnit.MINUTES.sleep(10);
    }
}
