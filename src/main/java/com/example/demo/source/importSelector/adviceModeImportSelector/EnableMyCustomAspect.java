package com.example.demo.source.importSelector.adviceModeImportSelector;

import org.springframework.context.annotation.AdviceMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableMyCustomAspect
{
    AdviceMode mode() default AdviceMode.PROXY;
}
