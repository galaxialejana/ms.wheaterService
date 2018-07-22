package com.galaxy.wheater.service.strategies;

import com.galaxy.wheater.pojo.WeatherState;

public interface IPredictionStrategy {

	public boolean vefiryCondition() throws Exception;
	public WeatherState getWeatherPrediction() throws Exception;
}
