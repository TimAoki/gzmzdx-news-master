package com.xh.utils;

/**
 * @Author 徐海
 * @DATE 2023/6/27 20:13
 * @Description:
 * @Version 1.01
 */

public interface ResultCode {
    public static Integer SUCCESS = 200; //成功
    public static Integer ERROR = 201; //失败

    public enum StatusCode {
        OK(200, "正确"),
        BAD_REQUEST(400, "错误的请求"),
        UNAUTHORIZED(401, "禁止访问"),
        NOT_FOUND(404, "没有可用的数据"),
        PWD_ERROR(300, "密码错误"),
        EXIT(403, "已经存在"),
        INTERNAL_SERVER_ERROR(500, "服务器遇到了一个未曾预料的状况"),
        SERVICE_UNAVAILABLE(503, "服务器当前无法处理请求"),
        ERROR(9999, "数据不能为空");

        private int code;
        private String reason;

        StatusCode(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public int getCode() {
            return code;
        }

        public String getReason() {
            return reason;
        }

        @Override
        public String toString() {
            return code + ": " + reason;
        }
    }



}
