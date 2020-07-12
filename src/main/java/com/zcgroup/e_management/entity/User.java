package com.zcgroup.e_management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField(value = "account")
    private String account;
    @TableField(value = "pass_word")
    private String passWord;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private String age;
    @TableField(value = "person_number")
    private String personNumber;
    @TableField(value = "sex")
    private String sex;
    @TableField(value = "address")
    private String address;

    public final static String ACCOUNT="account";
    public final static String PASS_WORD="pass_word";
    public final static String NAME="name";
    public final static String AGE="age";
    public final static String PERSON_NUMBER="person_number";
    public final static String SEX="sex";
    public final static String ADDRESS="address";

}
