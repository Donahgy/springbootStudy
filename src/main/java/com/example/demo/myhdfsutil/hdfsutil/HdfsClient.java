package com.example.demo.myhdfsutil.hdfsutil;

import com.example.demo.myevent.environmentevent.YmlUtil;

import java.util.Properties;


public class HdfsClient extends AbstractHdfsUtil
{
    @Override
    public Properties setProp()
    {
        String hdfsIp = YmlUtil.getString("hdfs.ip");
        return null;
    }
}
