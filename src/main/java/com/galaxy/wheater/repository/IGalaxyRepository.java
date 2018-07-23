package com.galaxy.wheater.repository;

import java.util.List;

import com.galaxy.wheater.pojo.SystemSun;
import com.galaxy.wheater.pojo.WeatherPrediction;

public interface IGalaxyRepository {
	public SystemSun getGalaxy();
	public void savePredictions(List<WeatherPrediction> list);
}
