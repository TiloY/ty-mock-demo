package com.ty.tymockdemo.validate;

import com.ty.tymockdemo.thread.Cycle;
import com.ty.tymockdemo.thread.TimeInterval;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/24 23:55
 * @Version : 1.0.0
 **/
public final class DateUtils {
   public static  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws ParseException {

        //判断某个日期是否在两个日期范围之外
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date1 = simpleDateFormat.parse("2019-06-20");
//        Date date2 = simpleDateFormat.parse("2019-07-25");
//
//        Date date3 = simpleDateFormat.parse("2019-07-26");
//
//        if (date1.getTime() > date3.getTime() || date2.getTime() < date3.getTime()) {
//            System.out.println("date3在date1和date2日期范围外！");
//        }



        Date date1 = simpleDateFormat.parse("2019-06-20");
        Date date2 = simpleDateFormat.parse("2019-07-25");

        Date date3 = simpleDateFormat.parse("2019-05-1");
        Date date4 = simpleDateFormat.parse("2019-06-23");

        Cycle cycle = new Cycle();
        cycle.setStartDate(date1);
        cycle.setEndDate(date2);

        TimeInterval timeInterval = new TimeInterval();
        timeInterval.setStart(date3);
        timeInterval.setEnd(date4);

        boolean checkOut = checkOut(cycle, timeInterval);
        System.out.println(checkOut);

    }

    // 因为周期一定连续
    public static boolean checkOut(Cycle cycle, TimeInterval timeInterval) {
        // 周期的开始时间   周期的结束时间
        Date timeIntervalStartDate = timeInterval.getStart();
        Date timeIntervalEndDat = timeInterval.getEnd();

        //期间的开始时间 期间的结束时间
        Date cycleStartDate = cycle.getStartDate();
        Date cycleEndDate = cycle.getEndDate();

        //说明期间落在了周期的外边
        if (compareDateWithOut(
                timeIntervalStartDate,
                timeIntervalEndDat,
                cycleStartDate)) {
            System.out.println("cycleStartDate在timeIntervalStartDate和timeIntervalEndDat日期范围外！");
            return false;
        }

         //记录下期间断
        //说明期间落在了周期的外边
        if (compareDateWithOut(
                timeIntervalStartDate,
                timeIntervalEndDat,
                cycleEndDate)) {
            System.out.println("cycleEndDate在timeIntervalStartDate和timeIntervalEndDat日期范围外！");
            return false;
        }

        return true;
    }

    private static boolean compareDateWithOut(Date start, Date end, Date cycleDate) {
        return start.getTime() > cycleDate.getTime() || end.getTime() < cycleDate.getTime();
    }
}
