package com.galaxy.wheater.repository;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.wheater.pojo.SystemSun;
import com.galaxy.wheater.pojo.WeatherPrediction;

@Component
public class GalaxyRepository implements IGalaxyRepository {

	private Logger logger = LoggerFactory.getLogger(GalaxyRepository.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${galaxy.dbservice.server}")
	private String dbServiceServer = "";
	
	
	@Autowired
	private ObjectMapper mapper;
	
	private String resourceGalaxyName = "db/galaxies";
	private String resourcePredictionDay = "db/dayPredictions";
	
	public SystemSun getGalaxy() {
		
		SystemSun result = null;
		String uri = dbServiceServer+"/" + resourceGalaxyName;
		
		
		try {
			
			ResponseEntity<String> response
			  = restTemplate.getForEntity(uri, String.class);
			
			result = mapper.readValue(response.getBody(), SystemSun.class);
		} catch (JsonParseException e) {
			logger.error(e.toString());
		} catch (JsonMappingException e) {
			logger.error(e.toString());
		} catch (Exception e) {
			logger.error(e.toString());
		}
		
		return result;
	}
	
	@Async
	public void savePredictions(List<WeatherPrediction> list) {
		for (WeatherPrediction weatherPrediction : list) {
			savePrediction(weatherPrediction);
		}
	}
	
	public void savePrediction(WeatherPrediction weatherPrediction) {
		
		String uri = dbServiceServer+"/" + resourcePredictionDay;
		
		try {
			WeatherPredictionBody body = new WeatherPredictionBody();
			body.setDay(weatherPrediction.getDay());
			body.setWeather(weatherPrediction.getState().getDescription());
			restTemplate.postForEntity(uri, body, String.class);
			
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}
}
