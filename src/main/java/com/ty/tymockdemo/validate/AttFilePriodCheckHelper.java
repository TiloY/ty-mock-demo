package com.ty.tymockdemo.validate;

import com.ty.tymockdemo.thread.Cycle;
import com.ty.tymockdemo.thread.TimeInterval;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/24 23:28
 * @Version : 1.0.0
 **/
public class AttFilePriodCheckHelper {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 考勤周期附表
     * 入參  檔案的 boid 集合
     *
     * @return Map<Long, List < Cycle>>  檔案的boid 考勤周期列表
     */
    public static Map<Long, List<Cycle>> loadAttFileBase() throws ParseException {
        Long boId = 0L;
        Map<Long, List<Cycle>> resultMap = new HashMap<>();
        List<Cycle> cycleArrayList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Cycle cycle = new Cycle();
            cycle.setBoId(boId);
            Date start = simpleDateFormat.parse("2019-0" + 3 + i + "-20");
            Date end = simpleDateFormat.parse("2019-0" + 4 + i + "-20");
            cycle.setStartDate(start);
            cycle.setEndDate(end);
            cycleArrayList.add(cycle);
        }
        resultMap.put(boId, cycleArrayList);

        return resultMap;
    }


    /**
     * 考勤期間表
     * Map<Long, Map<Long, List<TimeInterval>>>
     * boid       boid    期間列表
     *
     * @return
     */
    public static Map<Long, Map<Long, List<TimeInterval>>> loadPeriod() throws ParseException {
        Long boId = 0L;
        Map<Long, Map<Long, List<TimeInterval>>> resultMap = new HashMap<>();
        List<TimeInterval> timeIntervalArrayList = new ArrayList<>(5);
        Map<Long, List<TimeInterval>> timeInterMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            TimeInterval timeInterval = new TimeInterval();
            timeInterval.setBoId(boId);
            Date start = simpleDateFormat.parse("2019-0" + 3 + i + "-20");
            Date end = simpleDateFormat.parse("2019-0" + 4 + i + "-20");
            timeInterval.setStart(start);
            timeInterval.setEnd(end);
            timeIntervalArrayList.add(timeInterval);
        }
        timeInterMap.put(boId, timeIntervalArrayList);
        resultMap.put(boId, timeInterMap);
        return resultMap;
    }

    /**
     * 批量校验
     * @param boIdSets
     * @return
     */
    public static List<String> mainCheck(Set<Long> boIdSets) {

        return null ;
    }


}
