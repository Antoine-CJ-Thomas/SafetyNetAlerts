package com.safetynet.alerts.dto;

import java.util.ArrayList;

public class FloodAlertDTO {

	private String station;
	private ArrayList<HomeDTO> homes = new ArrayList<HomeDTO>();
	
	public FloodAlertDTO(String station) {
		this.station = station;
	}
	
	public void addHome(String address) {
		homes.add(new HomeDTO(address));
	}
	
	public void addInhabitantToHome(String address, String lastName, String phone, String age, ArrayList<String> medications, ArrayList<String> allergies) {
		
		for (HomeDTO h : homes) {
			
			if (h.getAddress().equals(address)) {
				
				h.addInhabitant(lastName, phone, age, medications, allergies);
			}
		}
	}
}