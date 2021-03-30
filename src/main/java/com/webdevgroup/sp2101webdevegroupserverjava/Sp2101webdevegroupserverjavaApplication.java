package com.webdevgroup.sp2101webdevegroupserverjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Sp2101webdevegroupserverjavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp2101webdevegroupserverjavaApplication.class, args);
    }


}
