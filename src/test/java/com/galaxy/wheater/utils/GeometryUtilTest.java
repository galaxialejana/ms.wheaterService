package com.galaxy.wheater.utils;


import static org.assertj.core.api.Assertions.assertThat;

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
}
