package com.example.demo.config;

import com.example.demo.service.MyImportBeanDefinitionRegistarServiceImpl;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义导入ImportBeanDefinitionRegistrar
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/20 12:03
 * @Version 1.0
 **/
public class MyImportBeanDefinitionRegistrar  implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //定义一个BeanDefinition
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(MyImportBeanDefinitionRegistarServiceImpl.class);
        //把自定义的bean定义导入到容器中
        beanDefinitionRegistry.registerBeanDefinition("MyImportBeanDefinitionRegistarServiceImpl",rootBeanDefinition);
    }
}
