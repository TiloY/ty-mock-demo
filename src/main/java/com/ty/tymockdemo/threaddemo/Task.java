package com.ty.tymockdemo.threaddemo;

import com.ty.tymockdemo.thread.Cycle;
import com.ty.tymockdemo.thread.TimeInterval;
import com.ty.tymockdemo.threaddemo.core.AbsTask;
import com.ty.tymockdemo.validate.DateUtils;

import java.util.*;

public class Task extends AbsTask<InEntity, Result> {

    public Task(InEntity t) {
        super(t);
    }

    @Override
    public Result work(InEntity t) {
        Map<Long, List<TimeInterval>> errMap = check(t.getCycle(), t.getCycleTimeIntervalList());

        Result ret = new Result();
        ret.setRet(null != errMap && errMap.size() == 0);
        ret.setMessage("成功");
        ret.setData(errMap);
        return ret;
    }


    /**
     * 校验逻辑
     *
     * @param cycle
     * @param cycleTimeIntervalList
     * @return
     */
    public Map<Long, List<TimeInterval>> check(Cycle cycle, List<TimeInterval> cycleTimeIntervalList) {
        System.out.println(" start cycle " + cycle);
        System.out.println("cycleTimeIntervalList " + cycleTimeIntervalList);
        Long boId = cycle.getBoId(); // 周期id


        // 1. 将周期进行排序
        cycleTimeIntervalList.sort(Comparator.comparing(TimeInterval::getStart));
        Map<Long, List<TimeInterval>> errMap = new HashMap<>();
        //错误点覆盖的 cycle 所在的时间点
        Date flagCycleDate = null;
        for (TimeInterval interval : cycleTimeIntervalList) {
            System.out.println("current cyc " + cycle);
            System.out.println("current interval " + interval);

            Date cycStart = cycle.getStartDate();
            Date cycEnd = cycle.getEndDate();

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

                // case2
            } else if (intervalStart.getTime() <= cycStart.getTime() && intervalEnd.getTime() > cycStart.getTime() && intervalEnd.getTime() <= cycEnd.getTime()) {
                cycle.setStartDate(intervalEnd);

                // case3
            } else if (intervalEnd.getTime() <= cycStart.getTime() && intervalEnd.getTime() >= cycEnd.getTime()) {
                Date date = new Date();
                cycle.setStartDate(date);
                cycle.setEndDate(date);
                return errMap;
                // case4
            } else if (intervalStart.getTime() >= cycStart.getTime() && intervalEnd.getTime() <= cycEnd.getTime()) {
                TimeInterval timeInterval = new TimeInterval();
                timeInterval.setBoId(cycle.getBoId());
                if (flagCycleDate != null) {
                    System.out.println(DateUtils.simpleDateFormat.format(flagCycleDate));
                    timeInterval.setStart(flagCycleDate);
                } else {
                    timeInterval.setStart(cycle.getStartDate());
                }

                timeInterval.setEnd(interval.getStart());
                fillErrMap(errMap, timeInterval);
                // 标记往右移动
                flagCycleDate = intervalEnd;

                cycle.setStartDate(intervalEnd);

                // case5
            } else if (intervalStart.getTime() > cycStart.getTime() && intervalEnd.getTime() >= cycEnd.getTime()) {
                TimeInterval timeInterval = new TimeInterval();

                if (flagCycleDate != null) {
                    timeInterval.setStart(flagCycleDate);
                } else {
                    timeInterval.setStart(cycStart);
                }
                timeInterval.setBoId(cycle.getBoId());
                timeInterval.setEnd(intervalStart);
                fillErrMap(errMap, timeInterval);

                flagCycleDate = intervalEnd;

                // case6
            } else if (intervalStart.getTime() > cycEnd.getTime()) {
                // 表示最小的期间都全部落在了 周期的右边   所以整个周期都未被覆盖

            }

            System.out.println(" end cycle " + cycle);
        }


        if (!DateUtils.simpleDateFormat.format(cycle.getStartDate()).equals(DateUtils.simpleDateFormat.format(cycle.getEndDate()))) {
            TimeInterval timeInterval = new TimeInterval();
            timeInterval.setStart(cycle.getStartDate());
            timeInterval.setEnd(cycle.getEndDate());
            timeInterval.setBoId(cycle.getBoId());
            fillErrMap(errMap, timeInterval);

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

}
