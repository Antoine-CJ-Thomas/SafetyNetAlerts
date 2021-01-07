package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class FloodAlertDTO {

	private String station;
	private ArrayList<HomeDTO> homes = new ArrayList<HomeDTO>();
	
	public FloodAlertDTO(String station) {
		this.station = station;
	}

	public String getStation() {
		return station;
	}

	public ArrayList<HomeDTO> getHomes() {
		return homes;
	}
}