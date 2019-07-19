package com.wyx.project.service.impl;

import com.wyx.project.entity.ScheduleJob;
import com.wyx.project.enums.JobOperateEnum;
import com.wyx.project.quartz.QuartzFactory;
import com.wyx.project.service.IScheduleJobService;
import com.wyx.project.service.QuartzService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * QuartzServiceImpl
 *
 * @author yuxiang
 * @date 2019/7/17 17:24
 **/
@Service
@Transactional
public class QuartzServiceImpl implements QuartzService {

    /**
     * 调度器
     */
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private IScheduleJobService iScheduleJobService;

    /**
     * 服务器启动执行定时任务
     *
     * @author lanjerry
     * @date 2019/1/28 15:38
     */
    @Override
    public void timingTask() {
        //查询数据库是否存在需要定时的任务

        List<ScheduleJob> scheduleJobs = iScheduleJobService.list();
        if (scheduleJobs != null) {
            scheduleJobs.forEach(this::addJob);
        }

    }

    /**
     * 新增定时任务
     *
     * @param job 任务
     * @author lanjerry
     * @date 2019/1/28 15:44
     */
    @Override
    public void addJob(ScheduleJob job) {
        try {
            //创建触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName())
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression()))
                    .startNow()
                    .build();

            //创建任务
            JobDetail jobDetail = JobBuilder.newJob(QuartzFactory.class)
                    .withIdentity(job.getJobName())
                    .build();

            //传入调度的数据，在QuartzFactory中需要使用
            jobDetail.getJobDataMap().put("scheduleJob", job);

            //调度作业
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 操作定时任务
     *
     * @param jobOperateEnum 操作枚举
     * @param job            任务
     * @author lanjerry
     * @date 2019/1/28 16:56
     */
    @Override
    public void operateJob(JobOperateEnum jobOperateEnum, ScheduleJob job) throws SchedulerException {
        JobKey jobKey = new JobKey(job.getJobName());
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            //抛异常
//            throw new RuntimeException("没有需要执行的");
        }

        switch (jobOperateEnum) {
            case START:
                scheduler.resumeJob(jobKey);
                break;
            case PAUSE:
                scheduler.pauseJob(jobKey);
                break;
            case DELETE:
                scheduler.deleteJob(jobKey);
                break;
            default:
                break;
        }
    }

    /**
     * 启动所有任务
     *
     * @author lanjerry
     * @date 2019/1/28 16:58
     */
    @Override
    public void startAllJob() throws SchedulerException {
        scheduler.start();
    }

    /**
     * 暂停所有任务
     *
     * @author lanjerry
     * @date 2019/1/28 16:58
     */
    @Override
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }
}
