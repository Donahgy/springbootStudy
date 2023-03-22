package com.example.demo.myhdfsutil.hdfsutil;

import com.example.demo.myhdfsutil.Environment;

import java.util.Properties;


public abstract class AbstractHdfsUtil implements Environment
{

    public AbstractHdfsUtil()
    {
        init();
    }

    private void init()
    {
        Properties prop = setProp();
    }
}
