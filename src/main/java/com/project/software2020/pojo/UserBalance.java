package com.project.software2020.pojo;

import java.sql.Timestamp;

public class UserBalance {
    private String user_id;
    private float balance;
    private Timestamp modified_time;

    public String getUser_id() {
        return user_id;
    }

    public float getBalance() {
        return balance;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }
}
