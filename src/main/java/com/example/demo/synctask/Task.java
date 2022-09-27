package com.example.demo.synctask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class Task
{
    public static Random random = new Random();

    @Async
    public void doTaskOne() throws Exception {
        System.out.println("开始执行任务一...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时："+(end - start));
    }

    @Async
    public void doTaskTwo() throws Exception {
        System.out.println("开始执行任务二...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时："+(end - start));
    }

    @Async
    public void doTaskThree() throws Exception {
        System.out.println("开始执行任务三...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时："+(end - start));
    }
}
