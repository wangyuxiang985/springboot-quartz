package com.wyx.project.controller;


import com.wyx.project.entity.ScheduleJob;
import com.wyx.project.service.IScheduleJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *@CrossOrigin 解决跨域问题，2.0以后要设置allowCredentials = "true" origins:是允许访问的列表（origins=“网址”）
 * @author yu xiang
 * @since 2018-04-02 
 */
@RestController
@RequestMapping("/job")
@CrossOrigin(allowCredentials = "true",origins = "*")
@Api(tags = "任务调度接口")
public class ScheduleJobController {

    @Autowired
    private IScheduleJobService iScheduleJobService;

    @GetMapping(value = "/hello")
    @ApiOperation("验证服务是否正常")
    public String helloSpringBoot() {
        return "Hello quartz!";
    }

    @GetMapping("/add")
    @ApiOperation("为任务添加定时任务")
    public String add() {
        ScheduleJob job = new ScheduleJob();
        job.setJobName("任务02");
        job.setCronExpression("0/2 * * * * ?");
        job.setBeanName("testJob02");
        job.setMethodName("execute");
        iScheduleJobService.add(job);
        return "新增定时任务成功";
    }

    @GetMapping("/start/{id}")
    @ApiOperation("启动某一定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",dataType = "int",name = "id",value = "任务主键id")
    })
    public String start(@PathVariable("id") Integer id) {
        iScheduleJobService.start(id);
        return "启动定时任务成功";
    }

    @GetMapping("/pause/{id}")
    @ApiOperation("暂停某一定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",dataType = "int",name = "id",value = "任务主键id")
    })
    public String pause(@PathVariable("id") Integer id) {
        iScheduleJobService.pause(id);
        return "暂停定时任务成功";
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("删除某一定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",dataType = "int",name = "id",value = "任务主键id")
    })
    public String delete(@PathVariable("id") Integer id) {
        iScheduleJobService.delete(id);
        return "删除定时任务成功";
    }

    @GetMapping("/startAllJob")
    @ApiOperation("启动所有定时任务")
    public String startAllJob() {
        iScheduleJobService.startAllJob();
        return "启动所有定时任务成功";
    }

    @GetMapping("/pauseAllJob")
    @ApiOperation("暂停所有定时任务")
    public String pauseAllJob() {
        iScheduleJobService.pauseAllJob();
        return "暂停所有定时任务成功";
    }
}
