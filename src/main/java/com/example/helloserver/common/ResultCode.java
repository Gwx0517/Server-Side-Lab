package com.example.helloserver.common;

public enum ResultCode {

    SUCCESS(200, "success"),
    USER_HAS_EXISTED(500, "用户已存在"),
    USER_NOT_EXIST(500, "用户不存在"),
    PASSWORD_ERROR(500, "密码错误"),
    PARAM_ERROR(500, "参数错误"),
    UPDATE_FAILED(500, "更新失败");

    private final Integer code;
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}