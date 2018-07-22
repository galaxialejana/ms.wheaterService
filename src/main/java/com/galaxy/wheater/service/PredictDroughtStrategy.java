package com.galaxy.wheater.service;

import java.util.List;

import com.galaxy.wheater.pojo.Point;
import com.galaxy.wheater.pojo.WheaterState;
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
	public WheaterState getWheaterPrediction() {
		
		WheaterState result = WheaterState.None;
		
		if(vefiryCondition()) {
			result = WheaterState.Drought;
		}
		return result;
	}
}
