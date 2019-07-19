package com.wyx.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "")
public class ScheduleJobVo {


    /** 任务id */
    @ApiModelProperty(value = "任务id", required = true)
    private Integer id;

    /** 任务名称 */
    @ApiModelProperty(value = "任务名称", required = true)
    private String jobName;

    /** cron表达式 */
    @ApiModelProperty(value = "cron表达式", required = true)
    private String cronExpression;

    /** 服务名称 */
    @ApiModelProperty(value = "服务名称", required = true)
    private String beanName;

    /** 方法名称 */
    @ApiModelProperty(value = "方法名称", required = true)
    private String methodName;

    /** 状态 1.启动 2.暂停 */
    @ApiModelProperty(value = "状态 1.启动 2.暂停", required = true)
    private Integer status;

    /** 是否删除 0.否 1.是 */
    @ApiModelProperty(value = "是否删除 0.否 1.是", required = true)
    private Integer deleteFlag;

    /** 创建人id */
    @ApiModelProperty(value = "创建人id", required = true)
    private Integer creatorId;

    /** 创建人 */
    @ApiModelProperty(value = "创建人", required = true)
    private String creatorName;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createdTime;

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间", required = true)
    private Date updatedTime;

}