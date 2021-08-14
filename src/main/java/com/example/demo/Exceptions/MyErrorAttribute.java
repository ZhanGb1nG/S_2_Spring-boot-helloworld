package com.example.demo.Exceptions;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义错误属性，用来构建页面属性信息
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/13 16:38
 * @Version 1.0
 **/
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest,
                                                  boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        Map<String, Object> map = (Map)webRequest.getAttribute("ext", 0);
        errorAttributes.put("ext", map);
        errorAttributes.put("company", "ZhanG_b1nG");

        return errorAttributes;
    }

}
