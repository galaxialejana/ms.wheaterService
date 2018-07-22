package com.galaxy.wheater.service.strategies;

import java.util.LinkedList;
import java.util.List;

import com.galaxy.wheater.pojo.Point;

public class PredictionStrategyManager {

	public static List<IPredictionStrategy> LoadStategies(List<Point> planetPoints, Point sun) {
		
		List<IPredictionStrategy> strategyList = new LinkedList<>();
		
		PredictBestConditionStrategy bestCondition = new PredictBestConditionStrategy(planetPoints, sun);
		PredictDroughtStrategy droughtStrategy = new PredictDroughtStrategy(planetPoints, sun);
		PredictRainingStrategy rainingStrategy = new PredictRainingStrategy(planetPoints, sun);
		
		strategyList.add(droughtStrategy);
		strategyList.add(rainingStrategy);
		strategyList.add(bestCondition);
		
		return strategyList;
	}

}
