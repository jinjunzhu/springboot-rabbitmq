package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinjunzhu
 * @date 2020/1/9
 */

@RestController
public class HealthController {

    @RequestMapping("/actuator/health")
    public String heath(){
        return "helloworld";
    }
}
