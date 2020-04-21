package com.nacos.producer.contant;

public enum ResponseCode {
    SUCCESS(200,"成功"),
    PARAM_ERROR_CODE(10002,"请求报文格式错误"),
    LIMIT_ERROR_CODE(10005,"请求超出限制"),
    SERVER_ERROR_CODE(500,"服务器错误");
    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg) {
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
