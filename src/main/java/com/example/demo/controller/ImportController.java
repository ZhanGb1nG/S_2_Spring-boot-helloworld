package com.example.demo.controller;

import com.example.demo.service.ImportServiceImpl;
import com.example.demo.service.MyImportBeanDefinitionRegistarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * import注解测试类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/20 11:59
 * @Version 1.0
 **/
@RestController
public class ImportController {
    @Autowired
    private ImportServiceImpl importService;

    @RequestMapping("testImport")
    public String testImport() {
        importService.testService();
        return "tulingOk";
    }

    @Autowired
    private MyImportBeanDefinitionRegistarServiceImpl registarService;

    @RequestMapping("testRegister")
    public String testRegister() {
        registarService.testTulingDao();
        return "tulingOk";
    }
}
