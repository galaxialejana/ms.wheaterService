package com.galaxy.wheater.service;


import com.galaxy.wheater.pojo.PredictionReport;

public interface IWeatherService {
	
	public PredictionReport predictWeather(int fromDay, int toDay) throws Exception;
}
