package com.ty.tymockdemo.threaddemo;

import com.ty.tymockdemo.thread.Cycle;
import com.ty.tymockdemo.thread.MyTask;
import com.ty.tymockdemo.thread.TimeInterval;
import com.ty.tymockdemo.threaddemo.core.AbsTask;
import com.ty.tymockdemo.threaddemo.core.WorkerManager;
import com.ty.tymockdemo.validate.DateUtils;

import java.text.ParseException;
import java.util.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ParseException {

		List<AbsTask<InEntity, Result>> list = new ArrayList<>();
		InEntity entity = null;
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
			entity = new InEntity();
			entity.setCycle(cycle01);
			entity.setCycleTimeIntervalList(timeIntervals);
			list.add(new Task(entity));
		}


//		Test test = new Test(); 单线程测试没有问题  
//		Map<Long, List<TimeInterval>> errMap = test.check(cycleMap.get(1L), cycleTimeIntervalMap.get(1L));
//		System.out.println(errMap);


		WorkerManager<InEntity, Result> manager = new WorkerManager<InEntity, Result>(list);
		List<Result> rets = manager.run();
		for (Result result : rets) {
			System.out.println(result.toString());
		}
	}



}
