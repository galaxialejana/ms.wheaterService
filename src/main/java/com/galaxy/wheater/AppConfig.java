package com.galaxy.wheater;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.galaxy.wheater.pojo.SystemSun;
import com.galaxy.wheater.repository.GalaxyRepository;
import com.galaxy.wheater.repository.IGalaxyRepository;
import com.galaxy.wheater.service.IWeatherService;
import com.galaxy.wheater.service.WeatherService;

@Configuration
public class AppConfig {
	
	@Autowired
	private IGalaxyRepository galaxyRepository;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public IWeatherService weatherService() {
		
		SystemSun galaxy = galaxyRepository.getGalaxy();
		return new WeatherService(galaxy.getPlanets(), galaxy.getSun());
	}
	
	@Bean
	public IGalaxyRepository galaxyRepository() {
		return new GalaxyRepository();
	}

}
