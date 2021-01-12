package com.project.software2020.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@ApiModel
public class User {
    @ApiModelProperty(value = "用户id")
    private String user_id;
    @ApiModelProperty(value = "用户名")
    private String user_name;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "修改时间")
    private Timestamp modified_time;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "用户余额")
    private float balance;
    @ApiModelProperty(value = "专业")
    private String major;
    @ApiModelProperty(value = "学院")
    private String school;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setModified_time(Timestamp last_modified_time) {
        this.modified_time = last_modified_time;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public String getPhone() {
        return phone;
    }

    public float getBalance() {
        return balance;
    }

    public String getMajor() {
        return major;
    }

    public String getSchool() {
        return school;
    }
}
