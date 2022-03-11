package com.statistics.coronavirus.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.statistics.coronavirus.model.CoronaDataResponse;

@Component
public class DataUtil {


	public static CoronaDataResponse getData() throws URISyntaxException, JsonMappingException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");  
		headers.set("x-rapidapi-key", "ea43e8f112msh1236ef3483375afp166309jsnfafebfb58b96");
		HttpEntity<CoronaDataResponse> httpEntity = new HttpEntity<CoronaDataResponse>(null, headers);
				 
		ResponseEntity<CoronaDataResponse> result = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, CoronaDataResponse.class);
		CoronaDataResponse res = result.getBody();
		System.out.println(res.getData().getCovid19Stats().size());
		return res;
	}
	
	public static void main(String[] args) throws URISyntaxException, JsonMappingException, JsonProcessingException {
		getData();
	}
}
