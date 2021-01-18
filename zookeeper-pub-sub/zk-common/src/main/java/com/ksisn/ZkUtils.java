package com.ksisn;

import org.I0Itec.zkclient.ZkClient;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kevin.lee
 * @date 2021/1/18 0018
 */
public class ZkUtils {

    private static final String ZK_PUB_SUB_ROOT = "/zk_pub_sub";
    private static final String ZK_PUB_SUB_ROOT2 = ZK_PUB_SUB_ROOT + "/";

    private static final ZkClient ZK_CLIENT = new ZkClient(ZKConfig.zkHost);
    private static final Set<String> topicSet = new HashSet<>();


    public static void pub(String path, String pullUrl) {
        // createPersistent(key);
        createEphemeral(path, pullUrl);
    }

    public static void sub(String path, SubListener listener) {
        ZK_CLIENT.subscribeDataChanges(ZK_PUB_SUB_ROOT2 + path, listener);
    }

    public static void deleteRecursive(String path) {
        ZK_CLIENT.deleteRecursive(ZK_PUB_SUB_ROOT2 + path);
    }

    private static void createEphemeral(String path, String value) {
        check();
        if (!topicSet.contains(path)) {
            topicSet.add(path);
            ZK_CLIENT.createEphemeral(ZK_PUB_SUB_ROOT2 + path, value);
        } else {
            ZK_CLIENT.writeData(ZK_PUB_SUB_ROOT2 + path, value);
        }
    }

    private static void check() {
        if (!ZK_CLIENT.exists(ZK_PUB_SUB_ROOT)) {
            ZK_CLIENT.createPersistent(ZK_PUB_SUB_ROOT, true);
        }
    }

}
