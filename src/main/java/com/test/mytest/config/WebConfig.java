package com.test.mytest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**") // 모든 경로에 대해 CORS 허용
                .allowedOrigins("http://localhost:3000",
                        "http://cloud-use-front-bucket.s3-website.ap-northeast-2.amazonaws.com/",
                        "https://d1nymhujoh4ldp.cloudfront.net/") // 허용할 Origin 설정
                .allowedHeaders("*")
                .allowedMethods("*") // 허용할 HTTP 메서드 설정
                .allowCredentials(true)
                .maxAge(3600); // Preflight 요청 결과를 캐시하는 시간 (초)
    }
}