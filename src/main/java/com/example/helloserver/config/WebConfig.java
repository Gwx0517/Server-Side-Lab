package com.example.helloserver.config;

import com.example.helloserver.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/api/**")
                // 放行：登录 + 注册 + 根据ID查询用户（全部放开，不再报401）
                .excludePathPatterns("/api/users/login")
                .excludePathPatterns("/api/users")          // 注册接口
                .excludePathPatterns("/api/users/*");        // 放行 /api/users/1、/api/users/2 等所有ID查询
    }
}