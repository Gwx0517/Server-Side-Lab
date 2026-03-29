package com.example.helloserver.config;


import com.example.helloserver.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 标记为配置类，SpringBoot自动扫描并加载
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()) // 注册自定义拦截器
                .addPathPatterns("/api/**") // 拦截/api下所有请求
                .excludePathPatterns("/api/users/login"); // 仅放行登录接口，其余由拦截器内部精细化控制
    }
}

