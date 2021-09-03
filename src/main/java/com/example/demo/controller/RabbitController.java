package com.example.demo.controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.rabbit.simple.SimpleSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ZhanG_b1nG
 * @Date 2021/9/3 20:32
 * @Version 1.0
 **/
@RequestMapping("/rabbit")
@Controller
public class RabbitController {

    @Autowired
    private SimpleSender simpleSender;

    @RequestMapping("/simple")
    @ResponseBody
    public CommonResult simpleSender() {
        simpleSender.sendMessage();
        return CommonResult.success(null);
    }

}
