package com.example.helloserver.config;

import com.example.helloserver.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 开启CORS（前后端分离必备）
                .cors(Customizer.withDefaults())
                // 关闭CSRF（无状态接口不需要）
                .csrf(AbstractHttpConfigurer::disable)
                // 关闭session（JWT等无状态认证）
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 授权规则
                .authorizeHttpRequests(auth -> auth
                        // 登录接口放行
                        .requestMatchers(new AntPathRequestMatcher("/api/users/login", POST.name())).permitAll()
                        // 注册接口放行
                        .requestMatchers(new AntPathRequestMatcher("/api/users", POST.name())).permitAll()
                        // 聊天接口放行
                        .requestMatchers(new AntPathRequestMatcher("/api/chat", POST.name())).permitAll()
                        // 所有其他请求必须认证
                        .anyRequest().authenticated()
                )
                // 添加JWT认证过滤器
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // 关闭表单登录（前后端分离用不到）
                .formLogin(AbstractHttpConfigurer::disable)
                // 关闭HTTP Basic认证（自定义认证方式）
                .httpBasic(AbstractHttpConfigurer::disable)
                // 异常处理：确保未认证请求返回401（默认逻辑，显式配置更清晰）
                .exceptionHandling(ex ->
                        ex.authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(401);
                            response.setContentType("application/json;charset=UTF-8");
                            response.getWriter().write("{\"code\":401,\"msg\":\"未认证，请先登录\"}");
                        })
                );

        return http.build();
    }
}