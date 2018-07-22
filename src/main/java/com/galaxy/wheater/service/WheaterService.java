package com.galaxy.wheater.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.galaxy.wheater.pojo.Planet;
import com.galaxy.wheater.pojo.Point;
import com.galaxy.wheater.pojo.PredictionReport;
import com.galaxy.wheater.pojo.Sun;
import com.galaxy.wheater.pojo.WheaterPrediction;
import com.galaxy.wheater.pojo.WheaterState;
import com.galaxy.wheater.service.strategies.IPredictionStrategy;
import com.galaxy.wheater.service.strategies.PredictionStrategyManager;
import com.galaxy.wheater.utils.GeometryUtil;

public class WheaterService implements IWheaterService {

	private List<Planet> planetList;
	private Sun sun;
	
	public WheaterService(List<Planet> planetList, Sun sun) {
		
		this.planetList = planetList;
		this.sun = sun;
	}
	
	@Override
	public PredictionReport predictWheater(int fromDay, int toDay) throws Exception {
		
		List<WheaterPrediction> predictionDays = new LinkedList<WheaterPrediction>();
		int maxDayRainIntensity = 0;
		double maxPerimeter = 0;
		HashMap<String, Integer> totals = new HashMap<>();
		totals.put(WheaterState.Raining.getDescription(), 0);
		totals.put(WheaterState.BestCondition.getDescription(), 0);
		totals.put(WheaterState.Drought.getDescription(), 0);
		for (int day = fromDay; day <= toDay; day++) {
			
			//calculate totals
			List<Point> planetPoints = getPlanetPoints(planetList, day);
			Point sunPoint = sun.getUbication();
			WheaterPrediction predictionDay = predictWheaterByDay(planetPoints, sunPoint, day);
			String wheaterDescription = predictionDay.getWheaterState().getDescription();
			totals.put(wheaterDescription, totals.get(wheaterDescription) + 1);
			
			//calculate max rain intensity
			double perimeter = GeometryUtil.calculatePerimeterFromListOfPoints(planetPoints);
			if(perimeter > maxPerimeter) {
				maxPerimeter = perimeter;
				maxDayRainIntensity = day;
			}
		}
		
		PredictionReport report = new PredictionReport(fromDay, toDay,predictionDays, totals, maxDayRainIntensity);
		
		return report;
	}

	public WheaterPrediction predictWheaterByDay(List<Point> planetPoints, Point sun, int day)  throws Exception {
		
		List<IPredictionStrategy> predictionStrategies = PredictionStrategyManager.LoadStategies(planetPoints, sun);
		WheaterState weather = null;
		for (IPredictionStrategy strategy : predictionStrategies) {
			weather = strategy.getWheaterPrediction();
			if(weather != null) {
				break;
			}
		}
		
		return new WheaterPrediction(day, weather);
	}

	private List<Point> getPlanetPoints(List<Planet> planetList, int day) {
		// TODO Auto-generated method stub
			List<Point> result = planetList.stream().map( p -> 
				adaptPlanetPositionToPoint(p, day)).collect(Collectors.toList());
			
		
		return result;
	}

	public static Point adaptPlanetPositionToPoint(Planet planet, int day) {
		
		double distance = planet.getDistance();
		double velocity = planet.getVelocity();
		double angle = velocity * day;
		
		
		return GeometryUtil.getPosition(distance, angle);
	}

}
