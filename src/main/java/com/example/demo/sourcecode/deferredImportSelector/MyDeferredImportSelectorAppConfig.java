package com.example.demo.sourcecode.deferredImportSelector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(MyDeferredImportSelector.class)
@Configuration
public class MyDeferredImportSelectorAppConfig
{
}
