//package com.webdevgroup.sp2101webdevegroupserverjava.config;
//
//import feign.Logger;
//import feign.RequestInterceptor;
//import feign.httpclient.ApacheHttpClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class StubHubConfig {
//
//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            requestTemplate.header("Authorization", "Bearer 3JKqVGhCzqtbkgPJLQwvR8UKpTW2");
//            requestTemplate.header("Accept", "application/json");
//            requestTemplate.header("Accept-Encoding", "gzip");
//        };
//    }
//
//    @Bean
//    public ApacheHttpClient client() {
//        return new ApacheHttpClient();
//    }
//}
