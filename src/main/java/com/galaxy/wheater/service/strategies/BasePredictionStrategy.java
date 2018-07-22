package com.galaxy.wheater.service.strategies;

import java.util.List;

import com.galaxy.wheater.pojo.Point;

public class BasePredictionStrategy {

	protected List<Point> planetPositions;
	protected Point sunPosition;

	public BasePredictionStrategy(List<Point> planetPositions, Point sunPosition) {
		this.planetPositions = planetPositions;
		this.sunPosition = sunPosition;
	}
}