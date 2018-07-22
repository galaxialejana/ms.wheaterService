package com.galaxy.wheater.service;


import com.galaxy.wheater.pojo.PredictionReport;

public interface IWheaterService {
	
	public PredictionReport predictWheater(int fromDay, int toDay) throws Exception;
}
