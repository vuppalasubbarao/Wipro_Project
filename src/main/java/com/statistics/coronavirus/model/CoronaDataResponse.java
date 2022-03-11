package com.statistics.coronavirus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class CoronaDataResponse {

	@JsonProperty("error")
	private boolean error;
	
	@JsonProperty("statusCode")
	private Integer statusCode;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("data")
	private Data data;

	
	public CoronaDataResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoronaDataResponse(boolean error, Integer statusCode, String message, Data data) {
		super();
		this.error = error;
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CoronaDataResponse [error=" + error + ", statusCode=" + statusCode + ", message=" + message + ", data="
				+ data + "]";
	}
	
	
}
