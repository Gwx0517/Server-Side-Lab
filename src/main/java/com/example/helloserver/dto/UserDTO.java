package com.example.helloserver.dto;


// 数据传输对象：仅接收前端注册/登录的用户名和密码
public class UserDTO {
    private String username;
    private String password;

    // Getter和Setter方法
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}