package com.example.demo.sourcecode.adviceModeImportSelector;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@EnableMyCustomAspect(mode = AdviceMode.ASPECTJ)
@Configuration
@Import(MyAdviceModeImportSelector.class)
public class MyAdviceModeImportSelectorAppConfig
{
}
