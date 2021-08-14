package com.example.demo.Exceptions;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常handler类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/12 18:16
 * @Version 1.0
 **/
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 自定义异常处理，浏览器显示json对象数据，非text/html
     *
     * @param ex
     * @param httpServletRequest
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @Author ZhanG_b1nG
     * @Date 2021/8/13 11:47
     */
//    @ExceptionHandler(value = MyException.class)
//    @ResponseBody
//    public Map<String, Object> dealException(MyException ex, HttpServletRequest httpServletRequest) {
//        Map<String, Object> map = new HashMap<>(8);
//        map.put("code", ex.getCode());
//        map.put("errorMsg", ex.getErrorMsg());
//
//        return map;
//    }

    /**
     * 自定义异常处理，浏览器显示hext/html，客户端显示json
     *
     * @param ex
     * @param httpServletRequest
     * @return java.lang.String
     * @Author ZhanG_b1nG
     * @Date 2021/8/13 12:08
     */
    @ExceptionHandler(value = MyException.class)
    public String adaptiveExceptionHandler(MyException ex, HttpServletRequest httpServletRequest) {
        Map<String, Object> map = new HashMap<>(8);
        map.put("code", ex.getCode());
        map.put("errorMsg", ex.getErrorMsg());
        httpServletRequest.setAttribute("javax.servlet.error.status_code", 500);
        httpServletRequest.setAttribute("ext", map);
        return "forward:/error";
    }
}
