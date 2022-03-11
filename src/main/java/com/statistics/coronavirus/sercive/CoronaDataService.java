package com.statistics.coronavirus.sercive;

import org.springframework.stereotype.Service;

import com.statistics.coronavirus.model.CoronaDataResponse;

@Service
public interface CoronaDataService {

	CoronaDataResponse getEntireWorldData();
	
	CoronaDataResponse getDataByCountry(String countryName);
}
