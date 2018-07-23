package com.galaxy.wheater.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.wheater.pojo.PeriodPrediction;
import com.galaxy.wheater.pojo.PredictionReport;
import com.galaxy.wheater.pojo.WeatherPrediction;
import com.galaxy.wheater.repository.IGalaxyRepository;
import com.galaxy.wheater.service.IWeatherService;

@RestController
@RequestMapping("/predictweather")
public class WeatherController {
	
	private Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	private IWeatherService weatherService;
	
	@Autowired IGalaxyRepository galaxyRepository;
	
	@PostMapping
	public PredictionReport predictWeather(@RequestBody PeriodPrediction period) {
		PredictionReport result = null;
		try {
			
			result = weatherService.predictWeather(period.getStartDay(), period.getEndDay());
			galaxyRepository.savePredictions(result.getPreditionsList());//penalizacion que no le corresponde a este servicio.
		} catch(Exception e) {
			logger.error(e.toString());
			logger.debug(e.toString());
		}
		
		return result;
	}
}
