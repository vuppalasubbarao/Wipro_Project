package com.statistics.coronavirus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.statistics.coronavirus.model.CoronaDataResponse;
import com.statistics.coronavirus.sercive.CoronaDataService;
@RestController
public class CoronaDataController {

	@Autowired
	private CoronaDataService coronaDataService;
	
	@GetMapping("/worldData")
	public ResponseEntity<CoronaDataResponse> getWorldData() {
		return new ResponseEntity<>(coronaDataService.getEntireWorldData(), HttpStatus.OK);
	}
	
	@GetMapping("/worldData/{countryName}")
	public ResponseEntity<CoronaDataResponse> getDataForGivenCountry(@PathVariable("countryName") String countryName) {
		return new ResponseEntity<>(coronaDataService.getDataByCountry(countryName), HttpStatus.OK);
	}
}
