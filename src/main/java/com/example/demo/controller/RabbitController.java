package com.example.demo.controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.rabbit.simple.SimpleSender;
import com.example.demo.rabbit.work.WorkSender;
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

    /**
     * 简单模式
     * http://localhost:8080/zhangbingbing/rabbit/simple
     *
     * @param
     * @return com.example.demo.common.api.CommonResult
     * @Author ZhanG_b1nG
     * @Date 2021/9/5 17:26
     */
    @RequestMapping("/simple")
    @ResponseBody
    public CommonResult simpleSender() {
        simpleSender.sendMessage();
        return CommonResult.success(null);
    }

    @Autowired
    private WorkSender workSender;

    /**
     * 工作模式
     * http://localhost:8080/zhangbingbing/rabbit/work
     *
     * @param
     * @return com.example.demo.common.api.CommonResult
     * @Author ZhanG_b1nG
     * @Date 2021/9/5 17:27
     */
    @RequestMapping("/work")
    @ResponseBody
    public CommonResult work() {
        for (int i = 0; i < 10; i++) {
            workSender.sendMessage(i);
        }
        return CommonResult.success(null);
    }

}
