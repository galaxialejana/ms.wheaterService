package com.galaxy.wheater.pojo;

public enum WeatherState {
	None("None"),
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
}
