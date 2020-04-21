package com.nacos.producer.exception;

/**
 * service异常
 * 一般service层捕获Exception转化为此异常或直接抛出，然后由dubbo或者controller层捕获
 *
 *
 * @title service异常
 * @date 2017/5/4
 * @since 1.0.0
 */
public class ServiceException extends RuntimeException {

    /**
     * 错误代码
     */
    private String errorCode = "9999";

    public ServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
