package com.wyx.project.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * SchedulerTask
 *
 * @author yuxiang
 * @date 2019/7/17 18:55
 **/
@Component
@EnableScheduling
public class SchedulerTask {
    private int count = 0;

//    @Scheduled(cron = "*/1 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  " + (count++));
        System.out.println("当前时间：" + LocalTime.now());
    }
}
