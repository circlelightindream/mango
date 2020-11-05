package com.treasuremountain.mango.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello mango
 *
 * @author  mengyuanming
 * @date  2020/10/27 6:11
 * @version 1.0
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public Object hello() {
        return "Hello Mango!";
    }

}
