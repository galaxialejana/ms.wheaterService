package com.galaxy.wheater.service.strategies;

import java.util.List;

import com.galaxy.wheater.pojo.Point;
import com.galaxy.wheater.pojo.WeatherState;
import com.galaxy.wheater.utils.GeometryUtil;

public class PredictRainingStrategy extends BasePredictionStrategy implements IPredictionStrategy {

	public PredictRainingStrategy(List<Point> planetPositions, Point sunPosition) {
		super(planetPositions, sunPosition);
	}

	@Override
	public boolean vefiryCondition() throws Exception {
		boolean result = true;
		
		result = GeometryUtil.IsPointInTheFigure(planetPositions, sunPosition);
		
		return result;
	}

	@Override
	public WeatherState getWeatherPrediction() throws Exception {
		WeatherState result = WeatherState.Normal;
		if(vefiryCondition()) {
			result = WeatherState.Raining;
		}
		
		return result;
	}

}
