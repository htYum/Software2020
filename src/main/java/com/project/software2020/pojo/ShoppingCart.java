package com.project.software2020.pojo;

import java.sql.Timestamp;

public class ShoppingCart {
    private String user_id;
    private int good_id;
    private Timestamp modified_time;

    public String getUser_id() {
        return user_id;
    }

    public int getGood_id() {
        return good_id;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }
}
