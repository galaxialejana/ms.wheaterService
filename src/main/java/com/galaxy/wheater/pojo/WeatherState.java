package com.galaxy.wheater.pojo;

public enum WeatherState {
	Normal("Normal"),
	Raining("Raining"),
	BestCondition("BestCondition"),
	Drought("Drought");
	
	private String description;
	
	private WeatherState(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
