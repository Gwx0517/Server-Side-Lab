package com.example.helloserver.service;

import com.example.helloserver.common.Result;
import com.example.helloserver.dto.UserDTO;

public interface UserService {
    // 用户注册
    Result<String> register(UserDTO userDTO);
    // 用户登录
    Result<String> login(UserDTO userDTO);
    // 根据ID查询用户
    Result<String> getUserById(Long id);
    // 分页查询用户列表
    Result<Object> getUserPage(Integer pageNum, Integer pageSize);
}