package com.ty.tymockdemo.thread;

import com.ty.tymockdemo.validate.DateUtils;

import java.util.Date;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/24 23:58
 * @Version : 1.0.0
 **/
public class TimeInterval {
    private Long boId;
    private Date start;
    private Date end;

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "TimeInterval{" +
                "boId=" + boId +
                ", start=" + DateUtils.simpleDateFormat.format(start) +
                ", end=" + DateUtils.simpleDateFormat.format(end) +
                '}';
    }
}
