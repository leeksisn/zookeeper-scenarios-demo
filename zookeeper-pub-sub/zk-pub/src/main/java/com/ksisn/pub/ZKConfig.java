package com.ksisn.pub;

import java.util.ResourceBundle;

/**
 * @author kevin.lee
 * @date 2021/1/18 0018
 */
public class ZKConfig {
    public static String zkHost;

    private static final String ZK_CONFIG = "zk";

    static {
        // 执行ZK初始化
        ResourceBundle bundle = ResourceBundle.getBundle(ZK_CONFIG);
        zkHost = bundle.getString("zk.host");
    }
}
