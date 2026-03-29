package com.example.helloserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 标记为MyBatis映射接口，SpringBoot自动扫描
public interface UserMapper extends BaseMapper<User> {
    // 继承BaseMapper后，自带insert/select/delete/update等方法，无需手写
}