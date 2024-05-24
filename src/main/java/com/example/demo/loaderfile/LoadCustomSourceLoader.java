package com.example.demo.loaderfile;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;


public class LoadCustomSourceLoader implements PropertySourceLoader
{
    @Override
    public String[] getFileExtensions()
    {
        return new String[0];
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource)
        throws IOException
    {
        return null;
    }
}
