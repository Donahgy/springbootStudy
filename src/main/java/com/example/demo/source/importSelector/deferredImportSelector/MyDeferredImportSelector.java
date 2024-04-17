package com.example.demo.source.importSelector.deferredImportSelector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/**
 *  用于实现延迟加载和选择性导入配置类的机制。它允许在 Spring 容器初始化时，根据运行时条件选择性地导入一组配置类。
 */
public class MyDeferredImportSelector implements DeferredImportSelector
{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata)
    {
        // 根据条件返回要导入的配置类的全限定类名
        if (someConditionIsMet()) {
            return new String[]{"com.example.demo.myconfig.MyConfig1"};
        } else {
            return new String[]{"com.example.demo.myconfig.MyConfig2"};
        }
    }


    private boolean someConditionIsMet() {
        // 在这里添加您的条件判断逻辑
        // 返回 true 或 false 决定要导入哪些配置类
        return true;
    }
}
