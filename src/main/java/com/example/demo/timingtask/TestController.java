package com.example.demo.timingtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    private final ScheduleTask scheduleTask;

    public TestController(ScheduleTask scheduleTask)
    {
        this.scheduleTask = scheduleTask;
    }


//    @PostMapping("/updateMapping")
//    public String updateCron(String cron)
//    {
//        log.info("new cron :{}", cron);
//        scheduleTask.setCron(cron);
//        log.info("scheduleTask {} ",scheduleTask);
//        return "ok";
//    }

    @PostMapping("/updateMapping")
    public String updateCron1(@RequestParam Map<String,Object> paramMap)
    {
        String cron = String.valueOf(paramMap.get("cron"));
        log.info("new cron :{}", cron);
        this.scheduleTask.setCron(cron);
        log.info("scheduleTask {} ",this.scheduleTask);
        return "ok";
    }

    @GetMapping("/updateTimer")
    public String updateTimer(Long timer) {
        log.info("new timer :{}", timer);
        scheduleTask.setTimer(timer);
        return "ok";
    }
}
