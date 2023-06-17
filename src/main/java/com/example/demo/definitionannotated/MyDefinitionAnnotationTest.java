package com.example.demo.definitionannotated;

import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
@MyDefinitionAnnotation(value = "hello world")
public class MyDefinitionAnnotationTest {

}
