package com.galaxy.wheater.pojo;

public class PeriodPrediction {

	private int startDay;
	private int endDay;
	
	public PeriodPrediction() {
		super();
	}
	
	public PeriodPrediction(int startDay, int endDay) {
		this.startDay = startDay;
		this.endDay = endDay;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	
	
}
