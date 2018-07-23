package com.galaxy.wheater.pojo;

import java.util.List;

public class SystemSun {
	
	private Sun sun;
	private List<Planet> planets;
	
	public SystemSun() {
		super();
	}
	
	public SystemSun(List<Planet> planets, Sun sun) {
		
		this.sun = sun;
		this.planets = planets;
		
	}

	public List<Planet> getPlanets() {
		return this.planets;
	}

	public Sun getSun() {
		return sun;
	}
}
