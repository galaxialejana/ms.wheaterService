package com.galaxy.wheater.service;

import java.util.List;

import com.galaxy.wheater.pojo.Point;
import com.galaxy.wheater.pojo.WheaterState;
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
	public WheaterState getWheaterPrediction() throws Exception {
		WheaterState result = WheaterState.None;
		if(vefiryCondition()) {
			result = WheaterState.Raining;
		}
		
		return result;
	}

}
