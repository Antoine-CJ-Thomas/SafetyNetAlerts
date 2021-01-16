package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of the response of a fire alert request
 */
public class FireInfoDTO {

	private String address;
	private String station;
	private ArrayList<InhabitantDTO> inhabitantList = new ArrayList<InhabitantDTO>();

	public FireInfoDTO(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getStation() {
		return station;
	}
	
	public void setInhabitantList(ArrayList<InhabitantDTO> inhabitantList) {
		this.inhabitantList = inhabitantList;
	}
	
	public ArrayList<InhabitantDTO> getInhabitantList() {
		return inhabitantList;
	}
}