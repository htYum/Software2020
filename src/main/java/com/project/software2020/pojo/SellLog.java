package com.project.software2020.pojo;

import java.sql.Timestamp;

public class SellLog {
    private int log_id;
    private String buyer_id;
    private String seller_id;
    private int good_id;
    private Timestamp modified_time;

    public int getLog_id() {
        return log_id;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public int getGood_id() {
        return good_id;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }
}
