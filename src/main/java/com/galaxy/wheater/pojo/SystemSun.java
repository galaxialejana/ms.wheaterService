package com.galaxy.wheater.pojo;

import java.util.List;

public class SystemSun {
	
	private List<Planet> planets;
	private Sun sun;
	
	public SystemSun(List<Planet> planets, Sun sun) {
		
		this.planets = planets;
		this.sun = sun;
	}

	public List<Planet> getPlanets() {
		return this.planets;
	}

	public Sun getSun() {
		return sun;
	}
}
