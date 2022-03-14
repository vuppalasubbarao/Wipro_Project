package com.statistics.coronavirus.serciveimpl;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.statistics.coronavirus.model.CoronaDataResponse;
import com.statistics.coronavirus.model.Covid19Stats;
import com.statistics.coronavirus.sercive.CoronaDataService;
import com.statistics.coronavirus.util.DataUtil;

@Service
public class CoronaDataServiceImpl implements CoronaDataService {

	@Override
	public CoronaDataResponse getEntireWorldData() {
		CoronaDataResponse response = null;
		try {
			response = DataUtil.getData();
		} catch (JsonMappingException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public CoronaDataResponse getDataByCountry(String countryName) {
		CoronaDataResponse response = null;
		try {
			response = DataUtil.getData();
			List<Covid19Stats> filteredResults = response.getData().getCovid19Stats().stream()
					.filter(country -> country.getCountry().equals(countryName)).collect(Collectors.toList());
			System.out.println(response.getData().getCovid19Stats().size());
			response.getData().getCovid19Stats().clear();
			System.out.println(response.getData().getCovid19Stats().size());
			response.getData().setCovid19Stats(filteredResults);
			System.out.println(response.getData().getCovid19Stats().size());

		} catch (JsonMappingException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public CoronaDataResponse getDataByCountryByCount(String countryName, Integer count) {
		CoronaDataResponse response = this.getDataByCountry(countryName);
		List<Covid19Stats> results = response.getData().getCovid19Stats();
		List<Covid19Stats> filteredResults = results.stream().limit(count).collect(Collectors.toList());
		response.getData().getCovid19Stats().clear();
		response.getData().setCovid19Stats(filteredResults);
		return response;
	}

}
