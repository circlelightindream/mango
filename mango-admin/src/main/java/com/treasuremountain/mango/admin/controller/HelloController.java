package com.treasuremountain.mango.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello mango
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/10/27 6:11
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public Object hello() {
        return "Hello Mango!";
    }

}
