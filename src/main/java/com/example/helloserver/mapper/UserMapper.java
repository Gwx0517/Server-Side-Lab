package com.example.helloserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper，继承BaseMapper自动拥有CRUD
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 无需写任何方法，BaseMapper 已包含：
    // insert、deleteById、updateById、selectById、selectList 等
}