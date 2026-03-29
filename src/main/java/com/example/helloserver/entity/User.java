package com.example.helloserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_user") // 绑定数据库表名
public class User {
    @TableId(type = IdType.AUTO) // 主键自增，对应数据库BIGSERIAL
    private Long id;
    private String username; // 用户名，与表字段一致
    private String password; // 密码，与表字段一致

    // Getter和Setter方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}