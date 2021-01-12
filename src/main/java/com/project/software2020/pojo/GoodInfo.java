package com.project.software2020.pojo;

import java.sql.Timestamp;

public class GoodInfo {
    private int good_id;
    private String good_name;
    private String user_id;
    private float price;
    private String description;
    private Timestamp modified_time;
    private int category;
    private int is_sold;

    public int getGood_id() {
        return good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getCategory() {
        return category;
    }

    public int getIs_sold() {
        return is_sold;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setIs_sold(int is_sold) {
        this.is_sold = is_sold;
    }
}
