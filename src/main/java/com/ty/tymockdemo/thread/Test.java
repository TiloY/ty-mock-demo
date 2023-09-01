package com.ty.tymockdemo.thread;

import com.ty.tymockdemo.validate.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/27 15:23
 * @Version : 1.0.0
 **/
public class Test {


    public static void main(String[] args) throws ParseException {

        //List<Cycle> cycleList = new ArrayList<>();
        Map<Long, Cycle> cycleMap = new HashMap<>();
        // 周期id      期间
        Map<Long, List<TimeInterval>> cycleTimeIntervalMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            List<TimeInterval> timeIntervals = new ArrayList<>();
            TimeInterval t1 = new TimeInterval();
            Long boId = Long.valueOf(i + 1);
            t1.setBoId(boId);//
            t1.setStart(DateUtils.simpleDateFormat.parse("2023-01-01"));
            t1.setEnd(DateUtils.simpleDateFormat.parse("2023-02-01"));

            TimeInterval t2 = new TimeInterval();
            t2.setBoId(boId);//
            t2.setStart(DateUtils.simpleDateFormat.parse("2023-03-01"));
            t2.setEnd(DateUtils.simpleDateFormat.parse("2023-04-01"));


            TimeInterval t3 = new TimeInterval();
            t3.setBoId(boId);//
            t3.setStart(DateUtils.simpleDateFormat.parse("2023-04-02"));
            t3.setEnd(DateUtils.simpleDateFormat.parse("2023-05-01"));


            TimeInterval t4 = new TimeInterval();
            t4.setBoId(boId);//
            t4.setStart(DateUtils.simpleDateFormat.parse("2023-05-02"));
            t4.setEnd(DateUtils.simpleDateFormat.parse("2023-09-01"));

            timeIntervals.add(t1);
            timeIntervals.add(t2);
            timeIntervals.add(t3);
            timeIntervals.add(t4);

            cycleTimeIntervalMap.put(boId, timeIntervals);

            Cycle cycle01 = new Cycle();
            cycle01.setBoId(boId);
            cycle01.setStartDate(DateUtils.simpleDateFormat.parse("2023-01-01"));
            cycle01.setEndDate(DateUtils.simpleDateFormat.parse("2023-10-01"));
            //cycleList.add(cycle01);
            cycleMap.put(boId, cycle01);
        }

        //ThreadPoolExecutor threadPoolExecutor = ThreadPoolExe.getInstance().getThreadPoolExecutor();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        cycleTimeIntervalMap.entrySet().forEach(entry -> {
            MyTask myTask = new MyTask();
            myTask.setCycle(cycleMap.get(entry.getKey()));
            myTask.setCycleTimeIntervalList(cycleTimeIntervalMap.get(entry.getKey()));
            threadPoolExecutor.submit(myTask);
        });

    }


}
