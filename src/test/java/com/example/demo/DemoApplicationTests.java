package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.example.demo.synctask.Task;
import com.example.demo.synctask.TaskFuture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
class DemoApplicationTests
{

    @Autowired
    Task task;

    @Autowired
    TaskFuture taskFuture;

    @Test
    public void test()
        throws Exception
    {
        long start = System.currentTimeMillis();
        Future<String> stringFutureOne = taskFuture.doTaskOne();
        Future<String> stringFutureTwo = taskFuture.doTaskTwo();
        Future<String> stringFutureThree = taskFuture.doTaskThree();
        while (true)
        {
            // 取消对应的任务
            stringFutureOne.cancel(true);
            if (stringFutureOne.isDone() && stringFutureTwo.isDone() && stringFutureThree.isDone())
            {
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，共耗时："+(end - start));
    }

    @Test
    void contextLoads()
        throws Exception
    {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }


}
