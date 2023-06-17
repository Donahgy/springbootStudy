package com.example.demo.definitionannotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Target注解可以定义当前自定义注解的作用范围
 *  Retention注解是判断注解的生效时机
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyDefinitionAnnotation {

    String value() default "自定义的注解";
}
