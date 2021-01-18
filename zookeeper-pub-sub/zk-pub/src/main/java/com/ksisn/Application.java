package com.ksisn;

import com.ksisn.pub.Publisher;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;
import java.util.Random;

/**
 * 接口描述：启动接口
 **/
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.headless(false).run(args);

        while (true) {
            int read = System.in.read();
            Publisher publisher = new Publisher("topic1");
            publisher.send("hello zk!" + new Random().nextInt());
        }
    }
}