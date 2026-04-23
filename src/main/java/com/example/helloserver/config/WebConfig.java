package com.example.helloserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 移除了旧的AuthInterceptor注册代码
    // 后续如果需要其他MVC配置，可在此添加
}