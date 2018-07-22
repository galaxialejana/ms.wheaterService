package com.galaxy.wheater.pojo;

import java.util.List;

public class SystemSun {
	
	private List<Element> elements;
	
	public SystemSun(List<Element> elements) {
		
		this.elements = elements;
	}

	public List<Element> getElements() {
		return elements;
	}
}
