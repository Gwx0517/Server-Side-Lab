package com.example.helloserver.common;

// 泛型类：T表示data的类型，支持任意数据返回
public class Result<T> {
    // 响应状态码
    private Integer code;
    // 响应提示信息
    private String msg;
    // 响应核心数据
    private T data;

    // 静态工厂方法：成功时调用
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    // 静态工厂方法：失败时调用（传入自定义状态码）
    public static <T> Result<T> error(ResultCode resultCode) {
        Result<T> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        result.setData(null);
        return result;
    }

    // Getter和Setter方法
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}