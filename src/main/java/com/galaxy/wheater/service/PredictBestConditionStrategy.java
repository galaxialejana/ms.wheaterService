package com.galaxy.wheater.service;

import java.util.LinkedList;
import java.util.List;

import com.galaxy.wheater.pojo.Point;
import com.galaxy.wheater.pojo.WheaterState;
import com.galaxy.wheater.utils.GeometryUtil;

public class PredictBestConditionStrategy extends BasePredictionStrategy implements IPredictionStrategy {

	
	
	public PredictBestConditionStrategy(List<Point> planetPositions, Point sunPosition) {
		super(planetPositions, sunPosition);
	}

	@Override
	public boolean vefiryCondition() throws Exception {
		
		List<Point> allPositions = new LinkedList<>(planetPositions);
		allPositions.add(sunPosition);
		
		return GeometryUtil.AreAligned(planetPositions) && !GeometryUtil.AreAligned(allPositions);
	}

	@Override
	public WheaterState getWheaterPrediction() throws Exception {
		WheaterState result = WheaterState.None;
		
		if(vefiryCondition()) {
			result = WheaterState.BestCondition;
		}
		
		return result;
	}
}
