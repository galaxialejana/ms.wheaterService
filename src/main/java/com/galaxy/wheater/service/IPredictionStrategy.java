package com.galaxy.wheater.service;

import com.galaxy.wheater.pojo.WheaterState;

public interface IPredictionStrategy {

	public boolean vefiryCondition() throws Exception;
	public WheaterState getWheaterPrediction() throws Exception;
}
