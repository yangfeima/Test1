package com.nacos.producer.exception;


/**
 * service异常类
 *一般service层捕获Exception转化为此异常或直接抛出，然后由dubbo或者controller层捕获
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
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
