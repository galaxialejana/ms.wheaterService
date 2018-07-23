package com.galaxy.wheater.pojo;

public class Planet extends Element{
	
	private String name;
	private double distance;
	private double velocity;
	
	public Planet() {
		super();
	}
	
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

	public void setName(String name) {
		this.name = name;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
}
