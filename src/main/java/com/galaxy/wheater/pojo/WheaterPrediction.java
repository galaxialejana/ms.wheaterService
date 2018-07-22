package com.galaxy.wheater.pojo;

public class WheaterPrediction {
	private int day;
	private WheaterState state;
	
	public WheaterPrediction(int day, WheaterState state) {
		this.day = day;
		this.state = state;
	}

	public int getDay() {
		return day;
	}

	public WheaterState getWheaterState() {
		return state;
	}
}
