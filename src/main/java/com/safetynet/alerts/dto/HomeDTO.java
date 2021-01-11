package com.safetynet.alerts.dto;

import java.util.ArrayList;

/**
 * This class stores the data of a home
 */
public class HomeDTO {
	
	private String address;
	private ArrayList<InhabitantDTO> inhabitants = new ArrayList<InhabitantDTO>();
	
	public HomeDTO(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public ArrayList<InhabitantDTO> getInhabitants() {
		return inhabitants;
	}
}