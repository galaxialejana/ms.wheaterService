package com.galaxy.wheater.pojo;

public class Planet extends Element{
	
	private double distance;
	private double velocity;
	
	public Planet(double distance, double velocity) {
		super(null);
		this.distance = distance;
		this.velocity = velocity;
	}

	public double getDistance() {
		return distance;
	}

	public double getVelocity() {
		return velocity;
	}
}
