package com.example.demo.myevent.environmentevent;

import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class YmlUtil {

    public static ConfigurableEnvironment environment;

    public static String getString(String key)
    {
        return environment.getProperty(key);
    }

    public static Map<String,Object> getSystemProperties()
    {
        return environment.getSystemProperties();
    }

    public static Map<String,Object> getSystemEnvironment()
    {
        return environment.getSystemEnvironment();
    }
}
