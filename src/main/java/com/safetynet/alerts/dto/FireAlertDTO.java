package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of the response of a fire alert request
 */
public class FireAlertDTO {

	private String address;
	private String station;
	private ArrayList<InhabitantDTO> inhabitants = new ArrayList<InhabitantDTO>();
	
	public FireAlertDTO(String address, String station) {
		this.address = address;
		this.station = station;
	}
	
	public String getAddress() {
		return address;
	}

	public String getStation() {
		return station;
	}
	
	public ArrayList<InhabitantDTO> getInhabitants() {
		return inhabitants;
	}
}