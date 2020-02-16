package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jinjunzhu
 * @date 2020/1/9
 */
@SpringBootApplication(scanBasePackages = {"com.boot"})
//@EnableEurekaClient
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
