package com.example.demo.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Author ZhanG_b1nG
 * @Date 2021/9/13 21:51
 * @Version 1.0
 **/
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("******调用BeanFactoryPostProcessor开始");
        String[] beanStr = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanStr) {
            System.out.println("bean name:"+beanName);
            if ("user".equals(beanName)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                System.out.println("修改user的age值");
                beanDefinition.getPropertyValues().add("age", "20");
            }
        }
        System.out.println("******调用BeanFactoryPostProcessor结束");
    }
}
