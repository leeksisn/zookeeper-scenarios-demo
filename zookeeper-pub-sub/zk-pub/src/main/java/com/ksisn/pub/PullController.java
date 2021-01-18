package com.ksisn.pub;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

/**
 * @author kevin.lee
 * @date 2021/1/18 0018
 */
@RestController
@RequestMapping("pull")
public class PullController {

    // 模拟消息存放位置，可以从数据库中查询得到
    public static final LinkedList<String> messages = new LinkedList<>();
    public static final String PULL_MSG_URL = "http://localhost:7777/pull/getLast";

    @RequestMapping("getLast")
    public String getLast() {
        return messages.getLast();
    }

}
