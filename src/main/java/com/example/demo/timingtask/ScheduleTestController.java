package com.example.demo.timingtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
public class ScheduleTestController {

    private final ScheduleTask scheduleTask;

    @Autowired
    public ScheduleTestController(ScheduleTask scheduleTask)
    {
        this.scheduleTask = scheduleTask;
    }


    @PostMapping("/updateMapping")
    public String updateCron(String cron)
    {
        log.info("new cron :{}", cron);
        scheduleTask.setCron(cron);
        scheduleTask.setTimer(2000L);
        log.info("scheduleTask {} ",scheduleTask);
        return "ok";
    }

    @PostMapping("/updateMapping1")
    public String updateCron1(@RequestParam Map<String,Object> paramMap)
    {
        String cron = String.valueOf(paramMap.get("cron"));
        log.info("new cron :{}", cron);
        this.scheduleTask.setCron(cron);
        log.info("scheduleTask {} ",this.scheduleTask);
        return "ok";
    }
}
