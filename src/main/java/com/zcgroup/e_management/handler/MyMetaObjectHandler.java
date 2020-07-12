package com.zcgroup.e_management.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充器 time/
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
      this.setFieldValByName("time",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }

}
