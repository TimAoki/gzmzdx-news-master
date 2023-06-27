package com.xh.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 徐海
 * @DATE 2023/6/27 20:12
 * @Description:
 * @Version 1.01
 */

//统一返回结果的类
@Data
public class TokenResult {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();


    //把构造方法私有
    private TokenResult() {
    }



    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public TokenResult success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public TokenResult message(String message) {
        this.setMessage(message);
        return this;
    }

    public TokenResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    //成功静态方法
    public static TokenResult ok() {
        TokenResult r = new TokenResult();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static TokenResult error() {
        TokenResult r = new TokenResult();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public TokenResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public TokenResult data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }



}
