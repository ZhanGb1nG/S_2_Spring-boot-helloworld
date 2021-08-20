package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * import配置类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/20 11:55
 * @Version 1.0
 **/
@Configuration
@Import({MySelector.class, MyImportBeanDefinitionRegistrar.class})
public class ImportConfig {
}
