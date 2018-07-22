package com.galaxy.wheater.utils;

import java.util.List;

import com.galaxy.wheater.pojo.Point;

public class GeometryUtil {
	
	public static Point getPosition(double distance, double angle) {
		//Y = coseno(angle) * radio
		//X = seno(angle) * radio
		
		double radians = Math.toRadians(angle);
		double y = Math.round(Math.cos(radians) * distance);
		double x = Math.round(Math.sin(radians) * distance);
		
		return new Point(x, y);
	}
	
	public static double calculatePerimeterFromListOfPoints(List<Point> list) throws Exception {
		double perimeter = 0;
		
		if(list.size() < 3) {
			throw new Exception("To calculate the perimeter at least we need three elements in the list");
		}
		
		Point point = list.get(0);
		
		for (int i = 1; i < list.size() - 1; i++) {
			Point point2 = list.get(i);
			double distance = calculateDistanceBetweenTwoPoints(point, point2);
			perimeter += distance;
			point = point2;
		}
		
		Point point2 = list.get(list.size() - 1);
		perimeter += calculateDistanceBetweenTwoPoints(point, point2);
		return perimeter;
	}
	
	public static double calculateDistanceBetweenTwoPoints(Point p1, Point  p2) {
		
		
		return Math.sqrt( Math.pow( (p1.getX() - p2.getX()), 2 ) + Math.pow( (p1.getY() - p2.getY()), 2 ) );
	}

}
