package com.xh.utils;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    private Boolean success;

    //把构造方法私有
    private Result() {
    }

    public static Result ok() {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static Result error() {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public Result(Integer code,Boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public Result(Integer code , String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String message) {
        this.message = message;
    }

    public static <T> Result<T> buildResult(Result result, T data) {
        return new Result<>(result.getCode(),result.getSuccess(),result.getMessage(), data);
    }
    public static <T> Result<T> buildResult(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> buildResult(Integer code, String message) {
        return new Result<>(code, message);
    }

    public static <T> Result<T> buildResult(String message) {
        return new Result<>(message);
    }



}
