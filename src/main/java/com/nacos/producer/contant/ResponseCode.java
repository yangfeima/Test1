package com.nacos.producer.contant;

/**
 * 返回码类
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(200,"成功"),
    /**
     * 请求报文格式错误
     */
    PARAM_ERROR_CODE(10002,"请求报文格式错误"),
    /**
     * 请求超出限制
     */
    LIMIT_ERROR_CODE(10005,"请求超出限制"),
    /**
     * 服务器错误
     */
    SERVER_ERROR_CODE(500,"服务器错误");
    private Integer code;
    private String msg;

    /**
     *构造方法
     * @author  HX0011159
     * @description  
     * @param  code
     * @param  msg
     * @return  
     * @date  2020/4/21
     */
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
