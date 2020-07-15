package com.zcgroup.e_management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@lombok.Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName("data")
public class Data implements Serializable {

    private static final long serialVersionUID = 2L;
    @TableField(value = "user_id")
    private String userId;
    @TableField(value = "location")
    private String location;
    @TableField(value = "temperature")
    private String temperature;
    @TableField(value = "around_injection")
    private String aroundInjection;
    @TableField(value = "time")
    private Date time;


    public final static String USER_ID="user_id";
    public final static String LOCATION="location";
    public final static String TEMPERATURE="temperature";
    public final static String AROUND_INJECTION="around_injection";
    public final static String TIME="time";


}
