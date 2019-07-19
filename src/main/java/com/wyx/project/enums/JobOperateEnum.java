package com.wyx.project.enums;

import lombok.Getter;

/**
 * JobOperateEnum
 *
 * @author yuxiang
 * @date 2019/7/17 15:14
 **/
@Getter
public enum JobOperateEnum {
    /**
     *
     */
    START(1, "启动"),
    PAUSE(2, "暂停"),
    DELETE(3, "删除");

    private final Integer value;
    private final String desc;

    JobOperateEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getEnumName() {
        return name();
    }

}
