package com.ty.tymockdemo.thread;

import com.ty.tymockdemo.validate.DateUtils;

import java.util.Date;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/24 23:37
 * @Version : 1.0.0
 **/
public class Cycle {

    private Long boId;
    private Date startDate ;
    private Date endDate ;

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "boId=" + boId +
                ", startDate=" + DateUtils.simpleDateFormat.format(startDate) +
                ", endDate=" + DateUtils.simpleDateFormat.format(endDate) +
                '}';
    }
}
