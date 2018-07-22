package com.galaxy.wheater.utils;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.galaxy.wheater.pojo.Point;



@RunWith(SpringJUnit4ClassRunner.class)
public class GeometryUtilTest {

	@Test
	public void GetPositionWhenAngleIsZeroSuccess() {
		
		double distance = 300;
		double angle = 0; 
		Point point = GeometryUtil.getPosition(distance, angle);
		
		assertThat(point.getX()).isEqualTo(0.0);
		assertThat(point.getY()).isEqualTo(distance);
	}
	
	@Test
	public void GetPositionWhenAngleIs90Success() {
		
		double distance = 300;
		double angle = 90; 
		Point point = GeometryUtil.getPosition(distance, angle);
		
		assertThat(point.getX()).isEqualTo(distance);
		assertThat(point.getY()).isEqualTo(0.0);
	}
	
	@Test
	public void GetPositionYEqualsAngle30ZeroSuccess() {
		
		double distance = 300;
		double angle = 30; 
		Point point = GeometryUtil.getPosition(distance, angle);
		
		assertThat(point.getX()).isLessThan(point.getY());
	}
	
	@Test
	public void GetPositionYEqualsAngle60ZeroSuccess() {
		
		double distance = 300;
		double angle = 60; 
		Point point = GeometryUtil.getPosition(distance, angle);
		
		assertThat(point.getY()).isLessThan(point.getX());
		assertThat(point.getX()).isGreaterThan(0.0);
		assertThat(point.getY()).isGreaterThan(0.0);
	}
	
	@Test
	public void GetPositionYEqualsAngle120ZeroSuccess() {
		
		double distance = 300;
		double angle = 120; 
		Point point = GeometryUtil.getPosition(distance, angle);
		
		assertThat(point.getX()).isGreaterThan(0.0);
		assertThat(point.getY()).isLessThan(0.0);
	}
	
	@Test
	public void GetPositionYEqualsAngle210ZeroSuccess() {
		
		double distance = 300;
		double angle = 210; 
		Point point = GeometryUtil.getPosition(distance, angle);
		
		assertThat(point.getX()).isLessThan(0.0);
		assertThat(point.getY()).isLessThan(0.0);
	}
	
	@Test
	public void GetPositionYEqualsAngle330ZeroSuccess() {
		
		double distance = 300;
		double angle = 330; 
		Point point = GeometryUtil.getPosition(distance, angle);
		
		assertThat(point.getX()).isLessThan(0.0);
		assertThat(point.getY()).isGreaterThan(0.0);
	}
	
	@Test
	public void CalculateDistanceBetweenTwoPointsYZeroSuccess() {
		
		Point p1 = new Point(-10, 0);
		Point p2 = new Point(10, 0);
		double expected = 20;
		double result = GeometryUtil.calculateDistanceBetweenTwoPoints(p1, p2);
		
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	public void CalculateDistanceBetweenTwoPointsXZeroSuccess() {
		
		Point p1 = new Point(0, 10);
		Point p2 = new Point(0, -5);
		double expected = 15;
		
		double result = GeometryUtil.calculateDistanceBetweenTwoPoints(p1, p2);
		
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	public void CalculatePerimeterFromSQuareFigure() throws Exception {
		
		Point p1 = new Point(5, 5);
		Point p2 = new Point(5, -5);
		Point p3 = new Point(-5, -5);
		Point p4 = new Point(-5, 5);
		List<Point> list = new LinkedList<Point>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		double expected = 40;
		double perimeter =  GeometryUtil.calculatePerimeterFromListOfPoints(list);
		
		assertThat(perimeter).isEqualTo(expected);
	}
	
	@Test
	public void AllPointsAreAlignedSuccess() {
		
		Point p1 = new Point(5, 5);
		Point p2 = new Point(-5, -5);
		Point p3 = new Point(-10, -10);
		Point p4 = new Point(20, 20);
		List<Point> points = new LinkedList<Point>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		
		boolean result = GeometryUtil.AreAligned(points);
		
		assertThat(result).isTrue();
		
		
	}
	

	@Test
	public void pointsAreNotAlignedSuccess() {
		
		Point p1 = new Point(5, 5);
		Point p2 = new Point(5, -5);
		Point p3 = new Point(10, -10);
		Point p4 = new Point(20, 20);
		List<Point> points = new LinkedList<Point>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		
		boolean result = GeometryUtil.AreAligned(points);
		
		assertThat(result).isFalse();	
	}
	

	@Test
	public void pointIsInsideTheFigureAreaSuccess() throws Exception {
		
		Point p = new Point(0, 0);
		Point p1 = new Point(15, 15);
		Point p2 = new Point(10, -10);
		Point p3 = new Point(-20, 5);
		List<Point> points = new LinkedList<Point>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		
		
		boolean result = GeometryUtil.IsPointInTheFigure(points, p);
		
		assertThat(result).isTrue();	
	}
	

	@Test
	public void pointIsNotInsideInTheFigureSuccess() throws Exception {
		
		Point p = new Point(0, 0);
		Point p1 = new Point(15, 15);
		Point p2 = new Point(10, 5);
		Point p3 = new Point(20, -5);
		List<Point> points = new LinkedList<Point>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		
		
		boolean result = GeometryUtil.IsPointInTheFigure(points, p);
		
		assertThat(result).isFalse();	
	}
}
