package com.galaxy.wheater.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.galaxy.wheater.pojo.Planet;
import com.galaxy.wheater.pojo.Point;
import com.galaxy.wheater.pojo.PredictionReport;
import com.galaxy.wheater.pojo.Sun;
import com.galaxy.wheater.pojo.WeatherPrediction;
import com.galaxy.wheater.pojo.WeatherState;
import com.galaxy.wheater.service.strategies.IPredictionStrategy;
import com.galaxy.wheater.service.strategies.PredictionStrategyManager;
import com.galaxy.wheater.utils.GeometryUtil;

public class WeatherService implements IWeatherService {

	private List<Planet> planetList;
	private Sun sun;
	
	public WeatherService(List<Planet> planetList, Sun sun) {
		
		this.planetList = planetList;
		this.sun = sun;
	}
	
	@Override
	public PredictionReport predictWeather(int fromDay, int toDay) throws Exception {
		
		List<WeatherPrediction> predictionDays = new LinkedList<WeatherPrediction>();
		int maxDayRainIntensity = 0;
		double maxPerimeter = 0;
		HashMap<String, Integer> totals = new HashMap<>();
		totals.put(WeatherState.Raining.getDescription(), 0);
		totals.put(WeatherState.BestCondition.getDescription(), 0);
		totals.put(WeatherState.Drought.getDescription(), 0);
		for (int day = fromDay; day <= toDay; day++) {
			
			//calculate totals
			List<Point> planetPoints = getPlanetPoints(planetList, day);
			Point sunPoint = sun.getUbication();
			WeatherPrediction predictionDay = predictWeatherByDay(planetPoints, sunPoint, day);
			String weatherDescription = predictionDay.getWeatherState().getDescription();
			totals.put(weatherDescription, totals.get(weatherDescription) + 1);
			
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

	public WeatherPrediction predictWeatherByDay(List<Point> planetPoints, Point sun, int day)  throws Exception {
		
		List<IPredictionStrategy> predictionStrategies = PredictionStrategyManager.LoadStategies(planetPoints, sun);
		WeatherState weather = null;
		for (IPredictionStrategy strategy : predictionStrategies) {
			weather = strategy.getWeatherPrediction();
			if(weather != null) {
				break;
			}
		}
		
		return new WeatherPrediction(day, weather);
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
