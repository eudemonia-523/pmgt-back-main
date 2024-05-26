package com.pmgt.krish.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8083") // 允许访问的来源，可以是具体的域名或 "*" 表示允许所有域名
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的 HTTP 请求方法
                .allowedHeaders("*"); // 允许的 HTTP 请求头，默认为 "*"，表示允许所有请求头
    }
}
