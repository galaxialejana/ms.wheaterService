package com.galaxy.wheater.service.strategies;

import java.util.List;

import com.galaxy.wheater.pojo.Point;
import com.galaxy.wheater.pojo.WeatherState;
import com.galaxy.wheater.utils.GeometryUtil;

public class PredictDroughtStrategy extends BasePredictionStrategy implements IPredictionStrategy {
	
	public PredictDroughtStrategy(List<Point> planetPositions, Point sunPosition) {
		super(planetPositions, sunPosition);
	}
	
	@Override
	public boolean vefiryCondition() {
		planetPositions.add(sunPosition);
		return GeometryUtil.AreAligned(planetPositions);
	}

	@Override
	public WeatherState getWeatherPrediction() {
		
		WeatherState result = WeatherState.None;
		
		if(vefiryCondition()) {
			result = WeatherState.Drought;
		}
		
		return result;
	}
}
