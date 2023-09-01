package com.ty.tymockdemo.threaddemo;

import com.ty.tymockdemo.thread.Cycle;
import com.ty.tymockdemo.thread.TimeInterval;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	private Cycle cycle;
	private List<TimeInterval> cycleTimeIntervalList = new ArrayList<>();

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public List<TimeInterval> getCycleTimeIntervalList() {
		return cycleTimeIntervalList;
	}

	public void setCycleTimeIntervalList(List<TimeInterval> cycleTimeIntervalList) {
		this.cycleTimeIntervalList = cycleTimeIntervalList;
	}
}
