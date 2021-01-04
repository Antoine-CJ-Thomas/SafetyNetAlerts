package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class HomeDTO {
	
	private String homeAddress;
	private ArrayList<InhabitantDTO> inhabitants = new ArrayList<InhabitantDTO>();
	
	public HomeDTO(String address) {
		this.homeAddress = address;
	}
	
	public void addInhabitant(String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		inhabitants.add(new InhabitantDTO(lastName, phone, age, medications, allergies));
	}
	public String getAddress() {
		return homeAddress;
	}
}