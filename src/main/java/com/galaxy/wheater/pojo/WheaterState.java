package com.galaxy.wheater.pojo;

public enum WheaterState {
	None("None"),
	Raining("Raining"),
	BestCondition("BestCondition"),
	Drought("Drought");
	
	private String description;
	
	private WheaterState(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
