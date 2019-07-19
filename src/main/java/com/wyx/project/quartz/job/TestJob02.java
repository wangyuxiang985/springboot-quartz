package com.wyx.project.quartz.job;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * TestJob01
 *
 * @author yuxiang
 * @date 2019/7/17 18:59
 **/
@Component()
@Transactional
public class TestJob02 {
    public void execute() {
        System.out.println("-------------------TestJob01任务执行开始-------------------");
        System.out.println(new Date());
        System.out.println("-------------------TestJob01任务执行结束-------------------");
    }
}
