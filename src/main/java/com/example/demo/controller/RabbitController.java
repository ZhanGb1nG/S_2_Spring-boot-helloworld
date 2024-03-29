package com.example.demo.controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.rabbit.direct.DirectSender;
import com.example.demo.rabbit.fanout.FanoutSender;
import com.example.demo.rabbit.simple.SimpleSender;
import com.example.demo.rabbit.topic.TopicSender;
import com.example.demo.rabbit.work.WorkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private TopicSender topicSender;

    /**
     * 通配符模式
     * http://localhost:8080/zhangbingbing/rabbit/topic
     *
     * @param
     * @return com.example.demo.common.api.CommonResult
     * @Author ZhanG_b1nG
     * @Date 2021/9/6 11:02
     */
    @RequestMapping("/topic")
    @ResponseBody
    public CommonResult topic() {
        for (int i = 0; i < 10; i++) {
            topicSender.send(i);
        }
        return CommonResult.success(null);
    }

    @Autowired
    private FanoutSender fanoutSender;

    /**
     * 发布订阅模式
     * http://localhost:8080/zhangbingbing/rabbit/fanout
     *
     * @param
     * @return com.example.demo.common.api.CommonResult
     * @Author ZhanG_b1nG
     * @Date 2021/9/6 13:03
     */
    @RequestMapping(value = "/fanout", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult fanout() {
        for (int i = 0; i < 10; i++) {
            fanoutSender.sendMessage(i);
        }
        return CommonResult.success(null);
    }

    @Autowired
    private DirectSender directSender;

    /**
     * 路由模式
     * http://localhost:8080/zhangbingbing/rabbit/direct
     *
     * @param
     * @return com.example.demo.common.api.CommonResult
     * @Author ZhanG_b1nG
     * @Date 2021/9/6 15:04
     */
    @RequestMapping(value = "/direct", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult direct() {
        for (int i = 0; i < 10; i++) {
            directSender.sendMessage(i);
        }
        return CommonResult.success(null);
    }

}
