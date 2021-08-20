package com.example.demo.component;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义条件组件
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/20 15:26
 * @Version 1.0
 **/
public class TulingConditional implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //容器中包含tulingAspect组件才返回Ture
        if(conditionContext.getBeanFactory().containsBean("tulingAspect")){
            return true;
        }else{
            return false;
        }
    }
}
