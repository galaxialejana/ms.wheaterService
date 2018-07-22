package com.galaxy.wheater.pojo;

import java.util.HashMap;
import java.util.List;

public class PredictionReport {

	private int fromDay;
	private int toDay;
	private List<WheaterPrediction> preditionsList;
	private int maxDayOfRainIntensity;
	private HashMap<String, Integer> totals;
	
	public PredictionReport(int fromDay, int toDay, List<WheaterPrediction> preditionsList, HashMap<String, Integer> totals, int maxDayOfRainIntensity) {
		super();
		this.fromDay = fromDay;
		this.toDay = toDay;
		this.preditionsList = preditionsList;
		this.totals = totals;
		this.maxDayOfRainIntensity = maxDayOfRainIntensity;
	}

	

	public int getFromDay() {
		return fromDay;
	}

	public int getToDay() {
		return toDay;
	}

	public List<WheaterPrediction> getPreditionsList() {
		return preditionsList;
	}

	public int getMaxDayOfRainIntensity() {
		return maxDayOfRainIntensity;
	}
	
	
}
