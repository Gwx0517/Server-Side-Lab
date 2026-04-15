package com.example.helloserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户个人信息实体类（对应 user_info 表）
 */
@Data
@TableName("user_info")
public class UserInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;         // 主键ID

    private String realName;    // 真实姓名（对应数据库 real_name，MyBatis-Plus 自动下划线转驼峰）
    private String phone;       // 手机号码
    private String address;     // 联系地址
    private Integer userId;     // 关联 sys_user 表的 id
}