package com.ksisn.pub;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin.lee
 * @date 2021/1/18 0018
 */
@RestController
@RequestMapping("pull")
public class PullController {

    @RequestMapping("getLast")
    public String getLast() {
        return "";
    }
}
