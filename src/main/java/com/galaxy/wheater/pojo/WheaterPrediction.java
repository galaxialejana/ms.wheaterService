package com.galaxy.wheater.pojo;

public class WheaterPrediction {
	private int day;
	private String wheater;
	
	public WheaterPrediction(int day, String wheater) {
		this.day = day;
		this.wheater = wheater;
	}

	public int getDay() {
		return day;
	}

	public String getWheater() {
		return wheater;
	}
}
