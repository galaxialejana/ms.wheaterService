package com.galaxy.wheater.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class WeatherPrediction {
	@JsonProperty
	private int day;
	
	@JsonProperty
	private WeatherState state;
	
	public WeatherPrediction() {
		super();
	}
	
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

	public WeatherState getState() {
		return state;
	}

	public void setState(WeatherState state) {
		this.state = state;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
}
