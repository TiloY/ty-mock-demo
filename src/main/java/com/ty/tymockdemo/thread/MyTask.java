package com.ty.tymockdemo.thread;

import com.ty.tymockdemo.validate.DateUtils;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/27 15:44
 * @Version : 1.0.0
 **/
public class MyTask implements Callable<Map<Long, List<TimeInterval>>> {

    private Cycle cycle;
    private List<TimeInterval> cycleTimeIntervalList = new ArrayList<>();

    @Override
    public Map<Long, List<TimeInterval>> call() throws Exception {
        return check(cycle, cycleTimeIntervalList);
    }

    /**
     * 校验逻辑
     *
     * @param cycle
     * @param cycleTimeIntervalList
     * @return
     */
    private Map<Long, List<TimeInterval>> check(Cycle cycle, List<TimeInterval> cycleTimeIntervalList) {

        Long boId = cycle.getBoId(); // 周期id
        Date cycStart = cycle.getStartDate();
        Date cycEnd = cycle.getEndDate();

        // 1. 将周期进行排序
        cycleTimeIntervalList.sort(Comparator.comparing(TimeInterval::getStart));
        Map<Long, List<TimeInterval>> errMap = new HashMap<>();
        for (TimeInterval interval : cycleTimeIntervalList) {

            Long intervalBoId = interval.getBoId(); // 期间对应的周期id
            Date intervalStart = interval.getStart();
            Date intervalEnd = interval.getEnd();

            if (!boId.equals(intervalBoId)) {
                continue;
            }
            /**
             *
             *   case1                                 cycStart-------------------cycEnd
             *    intervalStart------------intervalEnd
             *
             *   case2                                cycStart-------------------cycEnd
             *                        intervalStart------------intervalEnd
             *
             *   case3                               cycStart-------------------cycEnd
             *                         intervalStart---------------------------------------intervalEnd
             *
             *   case4
             *        cycStart---------------------------------------------cycEnd
             *                 intervalStart------------intervalEnd
             *
             *   case5
             *         cycStart-------------------cycEnd
             *                   intervalStart------------intervalEnd
             *
             *   case6
             *        cycStart----------------------cycEnd
             *                                              intervalStart------------intervalEnd
             */

            //case1
            if (intervalEnd.getTime() <= cycStart.getTime()) {
                continue;
                // case2
            } else if (intervalStart.getTime() <= cycStart.getTime() && intervalEnd.getTime() > cycStart.getTime() && intervalEnd.getTime() <= cycEnd.getTime()) {
                cycle.setStartDate(intervalEnd);
                continue;
                // case3
            } else if (intervalEnd.getTime() <= cycStart.getTime() && intervalEnd.getTime() >= cycEnd.getTime()) {
                return errMap;
                // case4
            } else if (intervalStart.getTime() > cycStart.getTime() && intervalEnd.getTime() <= cycEnd.getTime()) {
                TimeInterval timeInterval = new TimeInterval();
                timeInterval.setStart(cycStart);
                timeInterval.setEnd(intervalStart);
                fillErrMap(errMap, timeInterval);

                cycle.setStartDate(intervalEnd);
                continue;
                // case5
            } else if (intervalStart.getTime() > cycStart.getTime() && intervalEnd.getTime() >= cycEnd.getTime()) {
                TimeInterval timeInterval = new TimeInterval();
                timeInterval.setStart(cycStart);
                timeInterval.setEnd(intervalStart);
                fillErrMap(errMap, timeInterval);

                return errMap;
                // case6
            } else if (intervalStart.getTime() > cycEnd.getTime()) {
                // 表示最小的期间都全部落在了 周期的右边   所以整个周期都未被覆盖
                if (DateUtils.simpleDateFormat.format(cycleTimeIntervalList.get(0).getStart()).equals(DateUtils.simpleDateFormat.format(intervalStart))
                        || DateUtils.simpleDateFormat.format(cycleTimeIntervalList.get(0).getEnd()).equals(DateUtils.simpleDateFormat.format(intervalEnd))) {
                    TimeInterval timeInterval = new TimeInterval();
                    timeInterval.setStart(cycStart);
                    timeInterval.setEnd(cycEnd);
                    fillErrMap(errMap, timeInterval);
                    return errMap;
                }
            }


        }

        return errMap;
    }

    private void fillErrMap(Map<Long, List<TimeInterval>> errMap, TimeInterval timeInterval) {
        if (errMap.containsKey(timeInterval.getBoId())) {
            List<TimeInterval> timeIntervals = errMap.get(timeInterval.getBoId());
            timeIntervals.add(timeInterval);
        } else {
            List<TimeInterval> timeIntervals = new ArrayList<>();
            timeIntervals.add(timeInterval);
            errMap.put(timeInterval.getBoId(), timeIntervals);
        }
    }


    public void setCycleTimeIntervalList(List<TimeInterval> cycleTimeIntervalList) {
        this.cycleTimeIntervalList = cycleTimeIntervalList;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }
}
