package com.webdevgroup.sp2101webdevegroupserverjava.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.httpclient.ApacheHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StubHubConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.query("client_id","MjE2OTUwODJ8MTYxODA4NjcyNS44MzkzNTc2");
        };
    }

//    @Bean
//    public ApacheHttpClient client() {
//        return new ApacheHttpClient();
//    }
}
