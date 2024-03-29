package com.example.demo.exception;

public class CustomizeExcption  extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeExcption(ICustomeizeErroCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
