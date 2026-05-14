package com.example.helloserver.service;

import com.example.helloserver.common.Result;
import com.example.helloserver.dto.UserDTO;
import com.example.helloserver.entity.UserInfo;
import com.example.helloserver.vo.UserDetailVO;

public interface UserService {
    // 用户注册
    Result<String> register(UserDTO userDTO);
    // 用户登录
    Result<String> login(UserDTO userDTO);
    // 根据ID查询用户
    Result<String> getUserById(Long id);
    // 根据用户名查询用户
    Result<String> getUserByUsername(String username);
    // 分页查询用户列表
    Result<Object> getUserPage(Integer pageNum, Integer pageSize);
    // 获取用户详情
    Result<UserDetailVO> getUserDetail(Long userId);
    // 更新用户信息
    Result<String> updateUserInfo(UserInfo userInfo);
    // 删除用户
    Result<String> deleteUser(Long userId);
}