package com.statistics.coronavirus.model;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class Data {

	@JsonProperty("lastChecked")
	private OffsetDateTime lastChecked;
	
	@JsonProperty("covid19Stats")
	private List<Covid19Stats> covid19Stats;

	public OffsetDateTime getLastChecked() {
		return lastChecked;
	}

	public void setLastChecked(OffsetDateTime lastChecked) {
		this.lastChecked = lastChecked;
	}

	public List<Covid19Stats> getCovid19Stats() {
		return covid19Stats;
	}

	public void setCovid19Stats(List<Covid19Stats> covid19Stats) {
		this.covid19Stats = covid19Stats;
	}
	
	
}
