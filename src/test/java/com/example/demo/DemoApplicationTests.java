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

    public static void main(String[] args) {
        String json = "[\n" +
                "{\n" +
                "\"fieldName\": \"protocol\",\n" +
                "\"relation\": 0,\n" +
                "\"value\": \"SMTPS\"\n" +
                "},\n" +
                "{\n" +
                "\"fieldName\": \"protocol\",\n" +
                "\"relation\": 0,\n" +
                "\"value\": \"SMTP\"\n" +
                "},\n" +
                "{\n" +
                "\"fieldName\": \"event.match.rule.matchTimes\",\n" +
                "\"relation\": 3,\n" +
                "\"value\": \"100\"\n" +
                "},\n" +
                "{\n" +
                "\"fieldName\": \"event.match.rule.matchTimes\",\n" +
                "\"relation\": 1,\n" +
                "\"value\": \"10\"\n" +
                "},\n" +
                "{\n" +
                "\"fieldName\": \"event.match.rule.matchSecId\",\n" +
                "\"relation\": 3,\n" +
                "\"value\": \"4\"\n" +
                "},\n" +
                "{\n" +
                "\"fieldName\": \"event.match.rule.matchSecId\",\n" +
                "\"relation\": 1,\n" +
                "\"value\": \"0\"\n" +
                "}\n" +
                "]\n";

        List<Map<String,Object>> mapList = (List<Map<String, Object>>) JSON.parse(json);
        Map<String,Object> temp = new HashMap<>();
        mapList.stream()
                .reduce(null, (x, y) -> {
                    if (!CollectionUtils.isEmpty(x))
                    {
                        if (x.get("fieldName").equals(y.get("fieldName"))) {
                            temp.put(String.valueOf(x.get("fieldName")),x.get("value") + "," + y.get("value"));
                        }
                    }
                    return y;
                });
        System.out.println(temp);
    }

}
