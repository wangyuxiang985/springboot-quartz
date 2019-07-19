package com.wyx.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyx.project.entity.ScheduleJob;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
public interface IScheduleJobService extends IService<ScheduleJob> {

    void add(ScheduleJob job);

    void start(Integer id);

    void pause(Integer id);

    void delete(Integer id);

    void startAllJob();

    void pauseAllJob();
}
