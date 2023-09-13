package com.example.demo.source.importSelector.adviceModeImportSelector;

import org.springframework.aop.framework.ProxyConfig;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;


public class MyAdviceModeImportSelector extends AdviceModeImportSelector<EnableMyCustomAspect>
{
    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        switch (adviceMode) {
            case PROXY:
            case ASPECTJ:
                return new String[]{ProxyConfig.class.getName()};
            default:
                return new String[]{};
        }
    }
}
