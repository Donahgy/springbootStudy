package com.example.demo.myhdfsutil.commonutil;

import org.springframework.core.env.ConfigurableEnvironment;

// https://blog.csdn.net/xby7437/article/details/114654912
public class YmlUtil
{

    public static ConfigurableEnvironment environment;



    public static String getString(String propKey)
    {
        return environment.getProperty(propKey);
    }
}
