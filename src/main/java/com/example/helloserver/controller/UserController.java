package com.example.helloserver.controller;

import com.example.helloserver.common.Result;
import com.example.helloserver.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // 查：返回统一响应体
    @GetMapping("/{id}")
    public Result<String> getUser(@PathVariable("id") Long id) {
        String data = "查询成功，正在返回ID为" + id + "的用户信息";
        return Result.success(data);
    }

    // 增：返回统一响应体
    @PostMapping
    public Result<String> createUser(@RequestBody User user) {
        String data = "新增成功，接收到用户：" + user.getName() + "，年龄：" + user.getAge();
        return Result.success(data);
    }

    // 改：返回统一响应体
    @PutMapping("/{id}")
    public Result<String> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        String data = "更新成功，ID" + id + "的用户已修改为：" + user.getName();
        return Result.success(data);
    }

    // 删：返回统一响应体
    @DeleteMapping("/{id}")
    public Result<String> deleteUser(@PathVariable("id") Long id) {
        String data = "删除成功，已移除ID为" + id + "的用户";
        return Result.success(data);
    }
}