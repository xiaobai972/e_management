package com.zcgroup.e_management.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@lombok.Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {

    private String account;
    private String name;

    private String location;

    private String temperature;

    private String aroundInjection;

    private String time;

    public final static String ACCOUNT="account";
    public final static String NAME="name";
    public final static String LOCATION="location";
    public final static String TEMPERATURE="temperature";
    public final static String AROUND_INJECTION="around_injection";
    public final static String TIME="time";
}
