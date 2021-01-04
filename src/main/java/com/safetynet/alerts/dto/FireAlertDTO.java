package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class FireAlertDTO {

	private String address;
	private String station;
	
	private ArrayList<InhabitantDTO> inhabitants = new ArrayList<InhabitantDTO>();
	
	public FireAlertDTO(String address, String station) {
		this.address = address;
		this.station = station;
	}
	
	public void addInhabitant(String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		inhabitants.add(new InhabitantDTO(lastName, phone, age, medications, allergies));
	}
}