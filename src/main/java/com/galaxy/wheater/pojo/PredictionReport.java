package com.galaxy.wheater.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredictionReport {

	private int fromDay;
	private int toDay;
	
	@JsonProperty
	private ArrayList<WeatherPrediction> preditionsList;
	
	private int maxDayOfRainIntensity;
	
	@JsonProperty
	private HashMap<String, Integer> totals;
	
	public PredictionReport() {
		super();
	}
	
	public PredictionReport(int fromDay, int toDay, ArrayList<WeatherPrediction> preditionsList, HashMap<String, Integer> totals, int maxDayOfRainIntensity) {
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

	public List<WeatherPrediction> getPreditionsList() {
		return preditionsList;
	}

	public int getMaxDayOfRainIntensity() {
		return maxDayOfRainIntensity;
	}



	public HashMap<String, Integer> getTotals() {
		return totals;
	}

	public void setFromDay(int fromDay) {
		this.fromDay = fromDay;
	}

	public void setToDay(int toDay) {
		this.toDay = toDay;
	}

	public void setPreditionsList(ArrayList<WeatherPrediction> preditionsList) {
		this.preditionsList = preditionsList;
	}

	public void setMaxDayOfRainIntensity(int maxDayOfRainIntensity) {
		this.maxDayOfRainIntensity = maxDayOfRainIntensity;
	}

	public void setTotals(HashMap<String, Integer> totals) {
		this.totals = totals;
	}
}
