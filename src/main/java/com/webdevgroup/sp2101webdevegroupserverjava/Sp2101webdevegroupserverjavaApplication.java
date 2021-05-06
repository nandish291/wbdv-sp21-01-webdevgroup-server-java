package com.webdevgroup.sp2101webdevegroupserverjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@SpringBootApplication
@EnableFeignClients
public class Sp2101webdevegroupserverjavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp2101webdevegroupserverjavaApplication.class, args);
    }

    @Bean
    public CookieSerializer cookieSerializer(){
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setSameSite("None");
        return serializer;
    }


}
