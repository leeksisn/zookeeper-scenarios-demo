package com.ksisn;

import org.I0Itec.zkclient.IZkDataListener;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * @author kevin.lee
 * @date 2021/1/18 17:26
 */
public abstract class SubListener implements IZkDataListener {

    @Override
    public void handleDataChange(String dataPath, Object o) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(o.toString())).GET().build();

        CompletableFuture<Void> voidCompletableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())

                .thenApply(HttpResponse::body)
                // 当响应值之后
                .thenAccept(t -> {
                    afterReceived(t);
                });
    }

    @Override
    public void handleDataDeleted(String s) throws Exception {

    }

    /**
     * 收到msg消息后的处理
     *
     * @param latestMsg
     */
    public abstract void afterReceived(String latestMsg);
}
