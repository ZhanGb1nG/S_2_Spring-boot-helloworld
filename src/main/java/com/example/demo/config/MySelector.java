package com.example.demo.config;

import com.sun.corba.se.pept.transport.Selector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义selector
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/20 11:56
 * @Version 1.0
 **/
public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.example.demo.service.ImportServiceImpl"};
    }
}
