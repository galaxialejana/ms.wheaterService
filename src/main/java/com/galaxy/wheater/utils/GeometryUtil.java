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
		Point aux = point;
		for (int i = 1; i < list.size(); i++) {
			Point point2 = list.get(i);
			double distance = calculateDistanceBetweenTwoPoints(aux, point2);
			perimeter += distance;
			aux = point2;
		}
		
		Point point2 = list.get(list.size() - 1);
		perimeter += calculateDistanceBetweenTwoPoints(point, point2);
		return perimeter;
	}
	
	public static double calculateDistanceBetweenTwoPoints(Point p1, Point  p2) {
		
		return Math.sqrt( Math.pow( (p1.getX() - p2.getX()), 2 ) + Math.pow( (p1.getY() - p2.getY()), 2 ) );
	}
	
	public static boolean AreAligned(List<Point> points) {
		boolean result = true;
		
		if(points.size() < 3) {
			return result;
		}
		
		//build a equation of the line.
		Point p1 = points.get(0);
		Point p2 = points.get(1);
		
		double pendiente = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
		
		//verify if all next points are aligned in the equition of the line.
		for (int i = 2; i < points.size(); i++) {
			Point p = points.get(i);
			double leftSideEquation = p.getY() - p1.getY();
			double rightSideEquation = pendiente * (p.getX() - p1.getY());
			
			if(leftSideEquation != rightSideEquation) { // to be aligned both side of the equation must be equals.
				result = false;
				break;
			}
		}
		
		return result;
	}

	public static boolean IsPointInTheFigure (List<Point> figurePoints, Point p) throws Exception {

	    
	    if(figurePoints.size() < 3) {
	    	throw new Exception("a figure has at leat three points. The list you send has: " + figurePoints);
	    }
	    
	    Point p1 = figurePoints.get(0);
	    Point p2 = figurePoints.get(1);
	    boolean flagPointSide = calculatePointSide(p1, p2, p) < 0.0f;
	    Point previosPoint = p2;
	    for (int i = 2; i < figurePoints.size(); i++) {
	    	Point aux = figurePoints.get(i);
			boolean flagPointSide2 = calculatePointSide(previosPoint, aux, p) < 0.0f;
			
			if(flagPointSide != flagPointSide2) {
				return false;
			}
			
			previosPoint = aux;
		}

	    boolean flagPointSide2 = calculatePointSide(previosPoint, p1, p) < 0.0f;
	    //return ((b1 == b2) && (b2 == b3));
	    return flagPointSide && flagPointSide2;
	}
	
	private static double calculatePointSide(Point p1, Point p2, Point p)
	{
	    return (p.getX() - p2.getX()) * (p1.getY() - p2.getY()) - (p1.getX() - p2.getX()) * (p.getY() - p2.getY());
	}
}
