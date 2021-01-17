package com.ksisn.pub;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author kevin.lee
 * @date 2021/1/18 0018
 */
public class ZkUtils {

    private static final String ZK_PUB_SUB_ROOT = "/zk_pub_sub/";

    private static final ZkClient ZK_CLIENT = new ZkClient(ZKConfig.zkHost);

    public static void pub(String key, String pullUrl) {
        createPersistent(key, pullUrl);
    }

    public static void deleteRecursive(String path) {
        ZK_CLIENT.deleteRecursive(ZK_PUB_SUB_ROOT + path);
    }

    private static void createPersistent(String path, String value) {
        ZK_CLIENT.createPersistent(ZK_PUB_SUB_ROOT + path, true);
        ZK_CLIENT.writeData(path, value);
    }

    private static void createEphemeral(String path, String value) {
        ZK_CLIENT.createEphemeral(ZK_PUB_SUB_ROOT + path, value);
    }

}
