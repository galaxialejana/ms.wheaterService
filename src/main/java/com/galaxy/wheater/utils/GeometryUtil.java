package com.galaxy.wheater.utils;

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

}
