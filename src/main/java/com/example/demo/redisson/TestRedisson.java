package com.example.demo.redisson;

import com.example.demo.redisson.mapper.UserMapper;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Component
public class TestRedisson
{
    @Resource
    RedissonClient redissonClient;

    @Resource
    UserMapper userMapper;

    public void updateUser(String userId)
    {
        String locKey = "config"+userId;
        RLock lock = redissonClient.getLock(locKey);
        try
        {
            lock.lock(10, TimeUnit.MINUTES);
            Thread.sleep(1000);
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("name","pandong");
            userMap.put("age","21");
            userMap.put("userId",userId);
            userMapper.insertUser(userMap);
        }
        catch (Exception e)
        {

        }
        finally
        {
            lock.unlock();
        }
    }
}
