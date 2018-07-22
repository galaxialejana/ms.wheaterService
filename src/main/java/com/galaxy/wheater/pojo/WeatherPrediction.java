package com.galaxy.wheater.pojo;

public class WeatherPrediction {
	private int day;
	private WeatherState state;
	
	public WeatherPrediction(int day, WeatherState state) {
		this.day = day;
		this.state = state;
	}

	public int getDay() {
		return day;
	}

	public WeatherState getWeatherState() {
		return state;
	}
}
