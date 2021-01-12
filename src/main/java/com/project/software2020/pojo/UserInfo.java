package com.project.software2020.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserInfo {
    private int user_info_id;
    private String user_id;
    private String user_actual_name;
    private int identity_card_type;
    private String identity_card_num;
    private int phone;
    private String email;
    private char gender;
    private int point;
    private Timestamp register_time;
    private Timestamp birthday;
    private int vip_level;
    private BigDecimal balance;

    public void setUser_info_id(int user_info_id) {
        this.user_info_id = user_info_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_actual_name(String user_actual_name) {
        this.user_actual_name = user_actual_name;
    }

    public void setIdentity_card_type(int identity_card_type) {
        this.identity_card_type = identity_card_type;
    }

    public void setIdentity_card_num(String identity_card_num) {
        this.identity_card_num = identity_card_num;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setRegister_time(Timestamp register_time) {
        this.register_time = register_time;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public void setVip_level(int vip_level) {
        this.vip_level = vip_level;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getUser_info_id() {
        return user_info_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_actual_name() {
        return user_actual_name;
    }

    public int getIdentity_card_type() {
        return identity_card_type;
    }

    public String getIdentity_card_num() {
        return identity_card_num;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public int getPoint() {
        return point;
    }

    public Timestamp getRegister_time() {
        return register_time;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public int getVip_level() {
        return vip_level;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
