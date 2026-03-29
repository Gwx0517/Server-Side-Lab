package com.example.helloserver.service;


import com.example.helloserver.common.Result;
import com.example.helloserver.dto.UserDTO;

public interface UserService {
    // 用户注册
    Result<String> register(UserDTO userDTO);
    // 用户登录
    Result<String> login(UserDTO userDTO);
}