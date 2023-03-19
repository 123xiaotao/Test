package com.reggie.common;

/**
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException{
    String message;
    public CustomException(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

}
