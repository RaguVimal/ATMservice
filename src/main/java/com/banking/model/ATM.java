package com.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


public class ATM {

    @JsonProperty("Identification")
    private String identification;

    @JsonProperty("SupportedCurrencies")
    private List<String> supportedCurrencies;

    @JsonProperty("Location")
    private Location location;

    public ATM() {
    }

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public List<String> getSupportedCurrencies() {
		return supportedCurrencies;
	}

	public void setSupportedCurrencies(List<String> supportedCurrencies) {
		this.supportedCurrencies = supportedCurrencies;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
