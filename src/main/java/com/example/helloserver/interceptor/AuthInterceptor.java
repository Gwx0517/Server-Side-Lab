package com.example.helloserver.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 白名单，不需要登录就能访问
        String requestURI = request.getRequestURI();
        List<String> whiteList = Arrays.asList("/api/chat");
        if (whiteList.contains(requestURI)) {
            return true; // 直接放行，不校验token
        }

        // 1. 获取请求的HTTP动词（GET/POST/PUT/DELETE）和请求路径
        String method = request.getMethod();
        String uri = request.getRequestURI();

        // 2. 精细化放行规则：仅放行【POST/api/users（注册）】
        boolean isCreateUser = "POST".equalsIgnoreCase(method) && "/api/users".equals(uri);
        // 满足规则，直接放行，无需校验Token
        if (isCreateUser) {
            return true;
        }

        // 3. Token校验：从请求头获取Authorization（Token）
        String token = request.getHeader("Authorization");
        // 无Token则拦截，返回401JSON响应
        if (token == null || token.isEmpty()) {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            String errorJson = "{\"code\":401,\"msg\":\"非法操作：敏感动作["+method+"]需携带登录凭证\"}";
            PrintWriter writer = response.getWriter();
            writer.write(errorJson);
            writer.flush();
            writer.close();
            return false; // 返回false=拦截请求
        }

        // Token存在，放行请求
        return true;
    }
}