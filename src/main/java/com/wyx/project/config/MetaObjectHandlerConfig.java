package com.wyx.project.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MetaObjectHandlerConfig
 *
 * @author yuxiang
 * @date 2019/7/17 15:12
 **/
@Component
@Slf4j
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("********** MetaObjectHandlerConfig insertFill 插入方法实体填充");

        Date now = new Date();
        this.setFieldValByName("creatorId", 1, metaObject);
        this.setFieldValByName("creatorName", "admin", metaObject);
        this.setFieldValByName("createdTime", now, metaObject);
        this.setFieldValByName("deleteFlag", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("********** MetaObjectHandlerConfig updateFill 更新方法实体填充");

        this.setFieldValByName("updatedTime", new Date(), metaObject);
    }

}