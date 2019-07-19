package com.wyx.project.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * QuartzConfig
 *
 * @author yuxiang
 * @date 2019/7/17 15:12
 **/
@Configuration
public class QuartzConfig {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //覆盖已存在的任务
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //服务启动后延时60s执行，避免服务未启动就开始执行任务
        schedulerFactoryBean.setStartupDelay(60);
        return schedulerFactoryBean;
    }

    //创建scheduler对象
    @Bean(name = "scheduler")
    public Scheduler scheduler(){
        return schedulerFactoryBean().getScheduler();
    }
}
