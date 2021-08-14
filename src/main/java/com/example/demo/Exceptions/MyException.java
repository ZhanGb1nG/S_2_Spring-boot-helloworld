package com.example.demo.Exceptions;

import org.omg.SendingContext.RunTime;

/**
 * 自定义异常处理类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/12 18:06
 * @Version 1.0
 **/
public class MyException extends RuntimeException {
    private Integer code;

    private String errorMsg;

    public MyException(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
